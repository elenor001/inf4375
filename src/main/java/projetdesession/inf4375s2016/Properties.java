package projetdesession.inf4375s2016;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)

/**
 *
 * @author Sophia
 */
public class Properties {
    
    @JsonProperty("name") String name;
    @JsonProperty("description") String description;
    @JsonProperty("Date") String Date;
    @JsonProperty("Heure_debut") String Heure_debut;
    @JsonProperty("Heure_fin") String Heure_fin;
    @JsonProperty("Lieu") String Lieu;
    @JsonProperty("Camion") String Camion;
    @JsonProperty("Truckid") String Truckid;
    
    public Properties(){
        
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
    
    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    
    public String getHeure_debut() {
        return Heure_debut;
    }

    public void setHeure_debut(String Heure_debut) {
        this.Heure_debut = Heure_debut;
    }
    
    public String getHeure_fin() {
        return Heure_fin;
    }

    public void setHeure_fin(String Heure_fin) {
        this.Heure_fin = Heure_fin;
    }
    
    public String getLieu() {
        return Lieu;
    }

    public void setLieu(String Lieu) {
        this.Lieu = Lieu;
    }
    
    public String getCamion() {
        return Camion;
    }

    public void setCamion(String Camion) {
        this.Camion = Camion;
    }
    
    public String getTruckid() {
        return Truckid;
    }

    public void setTruckid(String Truckid) {
        this.Truckid = Truckid;
    }
    
    @Override
    public String toString() {
        return  "{" + 
                '"'+ "name" + '"' + ":" + '"'+ name + '"' + ',' +
                '"'+ "description" + '"' + ":" + '"'+ description + '"' + ',' +
                '"'+ "Date" + '"' + ":" + '"'+ Date + '"' + ',' +
                '"'+ "Heure_debut" + '"' + ":" + '"'+ Heure_debut + '"' + ',' +
                '"'+ "Heure_fin" + '"' + ":" + '"'+ Heure_fin + '"' + ',' +
                '"'+ "Lieu" + '"' + ":" + '"'+ Lieu + '"' + ',' +
                '"'+ "Camion" + '"' + ":" + '"'+ Camion + '"' + ',' +
                '"'+ "Truckid" + '"' + ":" + '"'+ Truckid + '"' +
                "}";
    }
}
