package Reto3_Ciclo3.Reto3_Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservation {
    @Autowired
    private InterfaceReservation crud4;
    
    public List<Reservation> getAll(){  //metodo que trae toda la tabla
        return (List<Reservation>) crud4.findAll();// findAll trae todo
    }
    public Optional <Reservation> getReservation(int idReservation){ // el Id no puede ir null el optional garantiza eso
        return crud4.findById(idReservation);
    }
    public Reservation save(Reservation reservation){  // crear uno nuevo
        return crud4.save(reservation);
    }    
    public void delete(Reservation reservation) {   
        crud4.delete(reservation);
    }    
}
