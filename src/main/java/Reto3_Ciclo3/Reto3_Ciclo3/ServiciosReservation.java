package Reto3_Ciclo3.Reto3_Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosReservation {
  @Autowired
    private  RepositorioReservation metodosCrud; // get, find y save
    
    public List<Reservation> getAll(){         //metodo Get
        return metodosCrud.getAll();
        
    }
    
    public Optional <Reservation> getReservation(int idReservation){ // el Id no puede ir null el optional garantiza eso
        return metodosCrud.getReservation(idReservation);
    }
    public Reservation save(Reservation reservation) {
        if(reservation.getIdReservation()== null){    //si el id no viene null lo guarda 
           return metodosCrud.save(reservation);
        
        }else{
            Optional<Reservation>reservacion=metodosCrud.getReservation(reservation.getIdReservation());
            if(reservacion == null) {  // si tiene el id  lo genera sino trae todos los metodos 
                return metodosCrud.save(reservation);         
            }else{
                return reservation;  
            }     
        
        }
    }
    public Reservation update (Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation>reservaciones=metodosCrud.getReservation(reservation.getIdReservation());
            if(reservaciones !=null){
               
                if(reservation.getStartDate()!=null){
                    reservaciones.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    reservaciones.get().setDevolutionDate(reservation.getDevolutionDate());
                }    
                if(reservation.getStatus()!=null){
                    reservaciones.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(reservaciones.get());
                return reservaciones.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    
    public boolean deleteReservation(int idReservation){
        Boolean reservacionBoolean=getReservation(idReservation).map(reservation ->{
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return reservacionBoolean;
    }  
}
