package Reto3_Ciclo3.Reto3_Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class RepositorioClient {
    @Autowired
    private InterfaceClient crud1;
    
    public List<Client> getAll(){  //metodo que trae toda la tabla
        return (List<Client>) crud1.findAll();// findAll trae todo
    }
    public Optional <Client> getClient(int idClient){ // el Id no puede ir null el optional garantiza eso
        return crud1.findById(idClient);
    }
    public Client save(Client client){  // crear uno nuevo
        return crud1.save(client);
    }
    public void delete(Client client) {   
        crud1.delete(client);
    } 
}
