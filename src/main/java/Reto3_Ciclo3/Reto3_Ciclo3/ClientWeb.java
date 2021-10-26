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
@RequestMapping("/api/Client/")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}) //los cross para los front

public class ClientWeb {
    @Autowired
    private ServiciosClient servicios; // se traen todos los servicios de la tabla 
    @GetMapping("all")
    public List <Client> getClient(){
        return servicios.getAll();
    }
    
    @GetMapping("/(id)")
    public Optional<Client> getClient (@PathVariable("id") int idClient){
        return servicios.getClient(idClient);
    }
    
    @PostMapping("/save")
    @ResponseStatus (HttpStatus.CREATED)
    public Client save (@RequestBody Client client){
        return servicios.save(client);
    }
    
    @PostMapping("/update")
    @ResponseStatus (HttpStatus.CREATED)
    public Client update (@RequestBody Client client){
        return servicios.update(client);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idClient){
        return servicios.deleteClient(idClient);
    } 
}
