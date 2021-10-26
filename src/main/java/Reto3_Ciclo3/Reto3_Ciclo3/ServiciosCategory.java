package Reto3_Ciclo3.Reto3_Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosCategory {
    @Autowired
    private  RepositorioCategory metodosCrud; // get, find y save
    
    public List<Category> getAll(){         //metodo Get
        return metodosCrud.getAll();
        
    }
    
    public Optional <Category> getCategory(int id){ // el Id no puede ir null el optional garantiza eso
        return metodosCrud.getCategory(id);
    }
    public Category save(Category category) {
        if(category.getId()== null){    //si el id no viene null lo guarda 
           return metodosCrud.save(category);
        
        }else{
            Optional<Category>categoria=metodosCrud.getCategory(category.getId());
            if(categoria == null) {  // si tiene el id  lo genera sino trae todos los metodos 
                return metodosCrud.save(category);  
            }else{     
                return category;    
            }
        
        }
    }
    
    public Category update (Category category){
        if(category.getId()!=null){
            Optional<Category>categorias=metodosCrud.getCategory(category.getId());
            if(categorias !=null){
                if(category.getDescription()!=null){
                    categorias.get().setDescription(category.getDescription());
                }  
                if(category.getName()!=null){
                    categorias.get().setName(category.getName());
                }               
                return metodosCrud.save(categorias.get());
            }else{
                return category;
            }   
        }else{
            return category;
        }
    }
    
    public boolean deleteCategory(int id){
        Boolean categoriaBoolean=getCategory(id).map(category ->{
            metodosCrud.delete(category);
            return true;
        }).orElse(false);
        return categoriaBoolean;
    }
    
}
