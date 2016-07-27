package projetdesession.inf4375s2016;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableScheduling
@Controller
//@EnableAutoConfiguration

/**
 *
 * @author Sophia
 */
public class ProjetController {
    
    @Autowired private HoraireRepository repository;
    
    @RequestMapping(value = "/resultat", method = RequestMethod.POST)
    String resultat(@ModelAttribute DateForm DateForm, Model model) {
        List<Camion> listeHoraires = repository.findHoraireWithDate
        (DateForm.getDu(),DateForm.getAu());
        model.addAttribute("liste-horaires", listeHoraires);
        model.addAttribute("nombreCamions", listeHoraires.size());
        return "resultat";
    }
    
    @RequestMapping("/")
    //@ResponseBody
    String home(Model model) {
        model.addAttribute("DateForm", new DateForm());
        return "index";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ProjetController.class, args);
    }
}
