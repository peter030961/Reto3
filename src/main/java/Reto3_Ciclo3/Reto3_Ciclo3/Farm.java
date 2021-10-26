package Reto3_Ciclo3.Reto3_Ciclo3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Entity
@Table(name = "farm") // crea automáticamente la tabla en el MySql
public class Farm implements Serializable{ // implements Serializable convierte en archivos binarios la clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String address;
    private Integer extension;
    private String name;
    private String description;
    
    
    @ManyToOne   // relacion de muchos a uno
    @JoinColumn(name="categoryid")
    @JsonIgnoreProperties("farm")
    private Category category;
    
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy = "farm")
    @JsonIgnoreProperties({"farm","client"})
    private List<Message> message;
    
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy = "farm")
    @JsonIgnoreProperties({"farm","client"})
    private List<Reservation> reservation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getExtension() {
        return extension;
    }

    public void setExtension(Integer extension) {
        this.extension = extension;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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