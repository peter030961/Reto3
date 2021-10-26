package Reto3_Ciclo3.Reto3_Ciclo3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client") // crea automáticamente la tabla en el MySql
public class Client implements Serializable {
   @Id
   @GeneratedValue (strategy= GenerationType.IDENTITY)
   private Integer id;
   private String email;
   private String password;
   private String name;
   private Integer age;
   
   //creación de relació 1 a muchos entre Category y Farm
   @OneToMany(cascade ={CascadeType.PERSIST},mappedBy="client")
   @JsonIgnoreProperties("client")
   public List<Message> message;
   
   @OneToMany(cascade ={CascadeType.PERSIST},mappedBy="client")
   @JsonIgnoreProperties("client")
   public List<Reservation> reservation; 

    public Integer getIdClient() {
        return id;
    }

    public void setIdClient(Integer idClient) {
        this.id = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }
    
}
