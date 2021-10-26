package Reto3_Ciclo3.Reto3_Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController   //las @ es la instrucción de spring para la creación de la API
@RequestMapping("/api/Reservation/")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}) //los cross para los front

public class ReservationWeb {
    @Autowired
    private ServiciosReservation servicios; // se traen todos los servicios de la tabla 
    @GetMapping("all")
    public List <Reservation> getReservation(){
        return servicios.getAll();
    }
    
    @GetMapping("/(id)")
    public Optional<Reservation> getReservation (@PathVariable("id") int idReservation){
        return servicios.getReservation(idReservation);
    }
    
    @PostMapping("/save")
    @ResponseStatus (HttpStatus.CREATED)
    public Reservation save (@RequestBody Reservation reservation){
        return servicios.save(reservation);
    }
    
    @PostMapping("/update")
    @ResponseStatus (HttpStatus.CREATED)
    public Reservation update (@RequestBody Reservation reservation){
        return servicios.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idReservation){
        return servicios.deleteReservation(idReservation);
    }
}
