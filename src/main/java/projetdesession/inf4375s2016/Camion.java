package projetdesession.inf4375s2016;

/**
 *
 * @author Sophia
 */
public class Camion {
    
    String nom;
    String lieu;
    String date;
    String heure_debut;
    String heure_fin;
    float longitude;
    float latitude;
    String truckid;
    
    Camion(){
        
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String Date) {
        this.date = Date;
    }
    
    public String getHeure_debut() {
        return this.heure_debut;
    }

    public void setHeure_debut(String Heure_debut) {
        this.heure_debut = Heure_debut;
    }
    
    public String getHeure_fin() {
        return this.heure_fin;
    }

    public void setHeure_fin(String Heure_fin) {
        this.heure_fin = Heure_fin;
    }
    
    public String getLieu() {
        return this.lieu;
    }

    public void setLieu(String Lieu) {
        this.lieu = Lieu;
    }
    
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getTruckid() {
        return truckid;
    }

    public void setTruckid(String Truckid) {
        this.truckid = Truckid;
    }
    
    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
    
    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
    
    public String toString() {
        return  "{" + 
                '"'+ "Nom" + '"' + ":" + '"'+ nom + '"' + ',' +
                '"'+ "Lieu" + '"' + ":" + '"'+ lieu + '"' + ',' +
                '"'+ "Date" + '"' + ":" + '"'+ date + '"' + ',' +
                '"'+ "Heure_debut" + '"' + ":" + '"'+ heure_debut + '"' + ',' +
                '"'+ "Heure_fin" + '"' + ":" + '"'+ heure_fin + '"' + ',' +
                '"'+ "longitude" + '"' + ":" + '"'+ longitude + '"' + ',' +
                '"'+ "latitude" + '"' + ":" + '"'+ latitude + '"' + ',' +
                '"'+ "Truckid" + '"' + ":" + '"'+ truckid + '"' +
                "}";
    }
    
    public static Camion create(String nom, String lieu, String date, String heure_debut, 
            String heure_fin, float longitude, float latitude, String truckid) {
        Camion camion = new Camion();
        camion.setNom(nom);
        camion.setLieu(lieu);
        camion.setDate(date);
        camion.setHeure_debut(heure_debut);
        camion.setHeure_fin(heure_fin);
        camion.setLongitude(longitude);
        camion.setLatitude(latitude);
        camion.setTruckid(truckid);
        return camion;
    }
}