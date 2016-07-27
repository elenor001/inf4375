package projetdesession.inf4375s2016;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Sophia
 */
@RestController
public class CamionController {
    
    @Autowired HoraireRepository repository;
    
    /*
    **p.e. GET /horaires-camions?du=2016-05-08&au=2016-05-15
    */
    @RequestMapping(value = "/horaires-camions", method = RequestMethod.GET)
    public int findHoraireWithDate(@RequestParam("du") String date1, 
            @RequestParam("au") String date2){
        return repository.findHoraireWithDate(date1, date2).size();
    }
}
