package projetdesession.inf4375s2016;

import java.sql.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sophia
 */
@Component
public class HoraireRepository {
    
    @Autowired private JdbcTemplate jdbcTemplate;
    Logger logo = LoggerFactory.getLogger(HoraireRepository.class);
    
    private static final String sql = 
            "INSERT INTO horaire(nom, lieu, date, heure_debut, heure_fin, "
                + "longitude, latitude, truckid) VALUES (?,?,?,?,?,?,?,?)";
    
    public void update(Liste liste){
        logo.info("Creating tables");
        jdbcTemplate.execute("DROP TABLE horaire IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE horaire(" +
                "id SERIAL, nom VARCHAR(255), lieu VARCHAR(255), date VARCHAR(255), "
                + "heure_debut VARCHAR(255), heure_fin VARCHAR(255), longitude FLOAT,"
                + "latitude FLOAT, truckid VARCHAR(255))");
        List<Camion> listeCamions = new ArrayList<Camion>();
        Camion c = null;
        for(int i = 0; i < liste.getFeatures().size(); i++){
            Geometry g = liste.getFeatures().get(i).getGeometry();
            Properties p = liste.getFeatures().get(i).getProperties();
            c = Camion.create(p.getCamion(), p.getLieu(), p.getDate(), p.getHeure_debut(), 
                    p.getHeure_fin(), g.getCoordinates().get(0), g.getCoordinates().get(1), 
                    p.getTruckid());
            listeCamions.add(c);
        }
        jdbcTemplate.batchUpdate(sql, listeCamions, listeCamions.size(), 
                new ParameterizedPreparedStatementSetter<Camion>() {
                    @Override
                    public void setValues(PreparedStatement ps, Camion camion) throws SQLException {
                        ps.setString(1, camion.getNom());
                        ps.setString(2, camion.getLieu());
                        ps.setString(3, camion.getDate());
                        ps.setString(4, camion.getHeure_debut());
                        ps.setString(5, camion.getHeure_fin());
                        ps.setFloat(6, camion.getLongitude());
                        ps.setFloat(7, camion.getLatitude());
                        ps.setString(8, camion.getTruckid());
                    }
                });
    }
    
     private static final String findAll = 
            "SELECT * FROM horaire";
    
    public List<Camion> findAllHoraire(){
        return jdbcTemplate.query(findAll, new CamionRowMapper());
    }
    
    private static final String find_with_date = 
            "SELECT * FROM horaire WHERE date BETWEEN ? and ?";
    
    public List<Camion> findHoraireWithDate(String date1, String date2){
         return jdbcTemplate.query(find_with_date, new Object[] {date1, date2},
                new CamionRowMapper());
    }
}

class CamionRowMapper implements RowMapper<Camion> {
    public Camion mapRow(ResultSet resultSet, int i) throws SQLException {
        //Logger logo = LoggerFactory.getLogger(HoraireRepository.class);
        Camion camion = new Camion();
        camion.setNom(resultSet.getString("nom"));
        camion.setLieu(resultSet.getString("lieu"));
        camion.setDate(resultSet.getString("date"));
        camion.setHeure_debut(resultSet.getString("heure_debut"));
        camion.setHeure_fin(resultSet.getString("heure_fin"));
        camion.setLongitude(resultSet.getFloat("longitude"));
        camion.setLatitude(resultSet.getFloat("latitude"));
        camion.setTruckid(resultSet.getString("truckid"));
        //logo.info(camion.toString());
        //logo.info("bye");
        return camion;
    }
}
