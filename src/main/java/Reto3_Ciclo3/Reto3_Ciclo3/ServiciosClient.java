package Reto3_Ciclo3.Reto3_Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosClient {
@Autowired
    private  RepositorioClient metodosCrud; // get, find y save
    
    public List<Client> getAll(){         //metodo Get
        return metodosCrud.getAll();
        
    }
    
    public Optional <Client> getClient(int idClient){ // el Id no puede ir null el optional garantiza eso
        return metodosCrud.getClient(idClient);
    }
    public Client save(Client client) {
        if(client.getIdClient()== null){    //si el id no viene null lo guarda 
           return metodosCrud.save(client);
        
        }else{
            Optional<Client>cliente=metodosCrud.getClient(client.getIdClient());
            if(cliente == null) {  // si tiene el id  lo genera sino trae todos los metodos 
                return metodosCrud.save(client);         
            }else{
                return client;  
            }     
        
        }
    }
    public Client update (Client client){
        if(client.getIdClient()!=null){
            Optional<Client>clientes=metodosCrud.getClient(client.getIdClient());
            if(clientes !=null){
                if(client.getName()!=null){
                    clientes.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    clientes.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    clientes.get().setPassword(client.getPassword());
                }
                metodosCrud.save(clientes.get());
                return clientes.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    
    public boolean deleteClient(int idClient){
        Boolean clienteBoolean=getClient(idClient).map(client ->{
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return clienteBoolean;
    }    
}
