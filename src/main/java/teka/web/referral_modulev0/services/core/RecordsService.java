package teka.web.referral_modulev0.services.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teka.web.referral_modulev0.models.core.Visit;
import teka.web.referral_modulev0.repositories.core.VisitRepository;

import java.util.List;

@Service
public class RecordsService {

    @Autowired
    VisitRepository visitRepository;


    public Visit createVisit(Visit visit){
         return visitRepository.save(visit);
    }

    public List<Visit> getVisitList(){
        return visitRepository.findAll();
    }
}
