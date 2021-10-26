package Reto3_Ciclo3.Reto3_Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioFarm {
    @Autowired
    private InterfaceFarm crud;
    
    public List<Farm> getAll(){  //metodo que trae toda la tabla
        return (List<Farm>) crud.findAll();// findAll trae todo
    }
    public Optional <Farm> getFarm(int id){ // el Id no puede ir null el optional garantiza eso
        return crud.findById(id);
    }
    public Farm save(Farm farm){  // crear uno nuevo
        return crud.save(farm);
    }
    public void delete(Farm farm) {   
        crud.delete(farm);
    } 
}
