package projetdesession.inf4375s2016;

import com.fasterxml.jackson.annotation.*;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)

/**
 *
 * @author Sophia
 */
public class Liste {
    
    private String type;
    private ArrayList<Features> features = new ArrayList<>();
    
    public Liste(){
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Features> getFeatures() {
        return features;
    }
    
    public void setFeatures(ArrayList<Features> features) {
        this.features = features;
    }
    
    public String featuresString(ArrayList<Features> features){
        String featurestring = "";
        for(int i = 0; i < features.size(); i++){
           featurestring += features.get(i);
        }
        return featurestring;
    }
    
    @Override
    public String toString() {
        return  "{" + 
                '"' + "type" + '"' + ':' + '"'+ type + '"' + ',' +
                '"' + "features" + '"' + ":[" + featuresString(features) +
                "]}";
    }
}
