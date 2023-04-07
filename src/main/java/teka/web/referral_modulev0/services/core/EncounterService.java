package teka.web.referral_modulev0.services.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teka.web.referral_modulev0.models.core.utils.Encounter;
import teka.web.referral_modulev0.repositories.core.utils.EncounterRepository;

import java.util.List;

@Service
public class EncounterService {

    @Autowired
    EncounterRepository encounterRepository;

    public List<Encounter> getAllEncounters(){
        return encounterRepository.findAll();
    }

    public Encounter saveEncounter(Encounter encounter){

        return encounterRepository.save(encounter);

    }
}
