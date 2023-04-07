package teka.web.referral_modulev0.services.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teka.web.referral_modulev0.models.core.HospitalLevel;
import teka.web.referral_modulev0.repositories.core.HospitalLevelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalLevelService {

    @Autowired
    HospitalLevelRepository hospitalLevelRepository;

    public List<HospitalLevel> getAllHospitalLevels(){
        return hospitalLevelRepository.findAll();
    }

    public Optional<HospitalLevel> getHospitalLevelById(Long id){
        return hospitalLevelRepository.findById(id);
    }

}
