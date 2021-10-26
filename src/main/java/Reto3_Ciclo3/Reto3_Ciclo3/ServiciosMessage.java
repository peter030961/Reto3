package Reto3_Ciclo3.Reto3_Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosMessage {
    @Autowired
    private  RepositorioMessage metodosCrud; // get, find y save
    
    public List<Message> getAll(){         //metodo Get
        return metodosCrud.getAll();
   }
 
    public Optional <Message> getMessage(int idMessage){ // el Id no puede ir null el optional garantiza eso
        return metodosCrud.getMessage(idMessage);
    }
    
    public Message save(Message message) {
        if(message.getIdMessage()== null){    //si el id no viene null lo guarda 
           return metodosCrud.save(message);
        
        }else{
            Optional<Message>mensaje=metodosCrud.getMessage(message.getIdMessage());
            if(mensaje == null) {  // si tiene el id  lo genera sino trae todos los metodos 
                return metodosCrud.save(message);         
            }else{
                return message;  
            }     
        
        }
    }
    public Message update (Message message){
        if(message.getIdMessage()!=null){
            Optional<Message>mensajes=metodosCrud.getMessage(message.getIdMessage());
            if(mensajes !=null){
                if(message.getMessageText()!=null){
                    mensajes.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(mensajes.get());
                return mensajes.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    
    public boolean deleteMessage(int idMessage){
        Boolean mensajeBoolean=getMessage(idMessage).map(message ->{
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return mensajeBoolean;
    }
}