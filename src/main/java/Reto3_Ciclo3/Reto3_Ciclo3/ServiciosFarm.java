package Reto3_Ciclo3.Reto3_Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosFarm {
    @Autowired
    private  RepositorioFarm metodosCrud; // get, find y save
    
    public List<Farm> getAll(){         //metodo Get
        return metodosCrud.getAll();
        
    }
    
    public Optional <Farm> getFarm(int id){ // el Id no puede ir null el optional garantiza eso
        return metodosCrud.getFarm(id);
    }
    public Farm save(Farm farm) {
        if(farm.getId()== null){    //si el id no viene null lo guarda 
           return metodosCrud.save(farm);
        
        }else{
            Optional<Farm>finca=metodosCrud.getFarm(farm.getId());
            if(finca == null) {  // si tiene el id  lo genera sino trae todos los metodos 
                return metodosCrud.save(farm);         
            }else{
                return farm;  
            }     
        
        }
    }
    public Farm update (Farm farm){
        if(farm.getId()!=null){
            Optional<Farm>fincas=metodosCrud.getFarm(farm.getId());
            if(fincas !=null){
                if(farm.getName()!=null){
                    fincas.get().setName(farm.getName());
                }
                if(farm.getAddress()!=null){
                    fincas.get().setAddress(farm.getAddress());
                }
                if(farm.getExtension()!=null){
                    fincas.get().setExtension(farm.getExtension());
                }
                if(farm.getDescription()!=null){
                    fincas.get().setDescription(farm.getDescription());
                }    
                if(farm.getCategory()!=null){
                    fincas.get().setCategory(farm.getCategory());
                }
                metodosCrud.save(fincas.get());
                return fincas.get();
            }else{
                return farm;
            }
        }else{
            return farm;
        }
    }
    
    public boolean deleteFarm(int id){
        Boolean fincaBoolean=getFarm(id).map(farm ->{
            metodosCrud.delete(farm);
            return true;
        }).orElse(false);
        return fincaBoolean;
    }
}
