package Reto3_Ciclo3.Reto3_Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCategory {
    @Autowired
    private InterfaceCategory crud2;
    
    public List<Category> getAll(){  //metodo que trae toda la tabla
        return (List<Category>) crud2.findAll();// findAll trae todo
    }
    public Optional <Category> getCategory(int id){ // el Id no puede ir null el optional garantiza eso
        return crud2.findById(id);
    }
    public Category save(Category category){  // crear uno nuevo
        return crud2.save(category);
    }    
    public void delete(Category category) {   
        crud2.delete(category);
    }
}
    
    
    
    

