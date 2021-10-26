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
@Table(name = "category") // crea automáticamente la tabla en el MySql
public class Category implements Serializable{ // implements Serializable convierte en archivos binarios la clase
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    
    //creación de relación 1 a muchos entre Category y Farm
    @OneToMany(cascade ={CascadeType.PERSIST},mappedBy="category")
    @JsonIgnoreProperties("category")
    private List<Farm> farm;

    //metodos get And Set metodos de la relación

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Farm> getFarm() {
        return farm;
    }

    public void setFarm(List<Farm> farm) {
        this.farm = farm;
    }

}
