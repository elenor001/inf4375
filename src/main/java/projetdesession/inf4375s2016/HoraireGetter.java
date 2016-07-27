package projetdesession.inf4375s2016;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Sophia
 */
@Component
public class HoraireGetter {
    Logger logo = LoggerFactory.getLogger(HoraireRepository.class);
    private static final String URL ="http://camionderue.com/donneesouvertes/geojson";
    
    @Autowired private HoraireRepository repository;
    @Scheduled(cron="*/10 * * * * ?")
    
    public void execute() {
        RestTemplate restTemplate = new RestTemplate();
        Liste liste = restTemplate.getForObject(URL, Liste.class);
        //logo.info("bla");
        repository.update(liste);
        //repository.findHoraire("2016-06-28", "2016-06-29");
    }
}
