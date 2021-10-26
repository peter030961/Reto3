package Reto3_Ciclo3.Reto3_Ciclo3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation") // crea automáticamente la tabla en el MySql
public class Reservation implements Serializable { // implements Serializable convierte en archivos binarios la clase
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Date startDate;
    private Date devolutionDate;
   // private String status="created";
    private String status;
     //creación de relació 1 a muchos entre Cliente y Farm
   @ManyToOne
   @JoinColumn(name="idCategory")
   @JsonIgnoreProperties({"reservation"})
   private Farm farm;
    
   @ManyToOne
   @JoinColumn(name="idClient")
   @JsonIgnoreProperties({"reservation","messages"})
   private Client client;
   
   //private String score; // depende del grupo 

    public Integer getIdReservation() {
        return id;
    }

    public void setIdReservation(Integer idReservation) {
        this.id = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

  //  public String getScore() {
    //    return score;
  //  }

//    public void setScore(String score) {
 //       this.score = score;
//    }

}
