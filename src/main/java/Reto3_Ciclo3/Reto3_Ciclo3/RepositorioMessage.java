package Reto3_Ciclo3.Reto3_Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioMessage {
    @Autowired
    private InterfaceMessage crud3;
    
    public List<Message> getAll(){  //metodo que trae toda la tabla
        return (List<Message>) crud3.findAll();// findAll trae todo
    }
    public Optional <Message> getMessage(int idMessage){ // el Id no puede ir null el optional garantiza eso
        return crud3.findById(idMessage);
    }
    public Message save(Message message){  // crear uno nuevo
        return crud3.save(message);
    }    
    public void delete(Message message) {   
        crud3.delete(message);
    }    
}
