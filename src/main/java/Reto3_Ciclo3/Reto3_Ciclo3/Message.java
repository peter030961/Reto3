package Reto3_Ciclo3.Reto3_Ciclo3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message") // crea automáticamente la tabla en el MySql
public class Message implements Serializable{ // implements Serializable convierte en archivos binarios la clase
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    
    //creación de relació 1 a muchos entre Cliente y Farm
   @ManyToOne
   @JoinColumn(name="id")
   @JsonIgnoreProperties({"message","client","reservation"})
   private Farm farm;
   
   @ManyToOne
   @JoinColumn(name="idClient")
   @JsonIgnoreProperties({"message","reservation","client"})
   private Client client; 

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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
  
}
