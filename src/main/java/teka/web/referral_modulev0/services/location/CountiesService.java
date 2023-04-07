package teka.web.referral_modulev0.services.location;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teka.web.referral_modulev0.dto.CountyDto;
import teka.web.referral_modulev0.dto.SubCountyDto;
import teka.web.referral_modulev0.repositories.location.CountiesRepository;
import teka.web.referral_modulev0.repositories.location.SubCountiesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CountiesService {

    @Autowired
    CountiesRepository countiesRepository;
    @Autowired
    SubCountiesRepository subCountiesRepository;

    public List<CountyDto> getAllCounties(){
        return countiesRepository.findAll();
    }

    public List<SubCountyDto> getAllSubCounties(){
        return subCountiesRepository.findAll();
    }

    public Optional<CountyDto> getCountyById(Long id){
        return countiesRepository.findById(id);
    }

    public Optional<SubCountyDto> getSubCountyById(Long id){
        return subCountiesRepository.findById(id);
    }
}
