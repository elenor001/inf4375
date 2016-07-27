package projetdesession.inf4375s2016;

import com.fasterxml.jackson.annotation.*;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)

/**
 *
 * @author Sophia
 */
public class Geometry {
    
    private String type;
    private ArrayList<Float> coordinates = new ArrayList<>();
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Float> getCoordinates() {
        return coordinates;
    }
    
    public void setCoordinates(ArrayList<Float> coordinates) {
        this.coordinates = coordinates;
    }
    
    public String coordinatesRead(ArrayList<Float> coordinates){
        String coordinatestring = "[";
        coordinatestring += coordinates.get(0) + "," + coordinates.get(1) + "]";
        return coordinatestring;
    }
    
    @Override
    public String toString() {
        return  "{" + 
                '"' + "type" + '"' + ':' + '"' + type + '"' + ',' +
                '"' + "coordinates" + '"' + ':' + coordinatesRead(coordinates) +
                "},";
    }
}
