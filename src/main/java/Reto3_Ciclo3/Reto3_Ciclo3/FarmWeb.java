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
@RequestMapping("/api/Farm/")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}) //los cross para los front

public class FarmWeb { //Controlador Web de Farm
    @Autowired
    private ServiciosFarm servicios; // se traen todos los servicios de la tabla 
    @GetMapping("all")
    public List <Farm> getFarm(){
        return servicios.getAll();
    }
    
    @GetMapping("/(id)")
    public Optional<Farm> getFarm (@PathVariable("id") int id){
        return servicios.getFarm(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus (HttpStatus.CREATED)
    public Farm save (@RequestBody Farm farm){
        return servicios.save(farm);
    }
    
    @PostMapping("/update")
    @ResponseStatus (HttpStatus.CREATED)
    public Farm update (@RequestBody Farm farm){
        return servicios.update(farm);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return servicios.deleteFarm(id);
    }
}