package teka.web.referral_modulev0.services.core;

import org.springframework.beans.factory.annotation.Autowired;
import teka.web.referral_modulev0.models.core.HospitalLevel;
import teka.web.referral_modulev0.models.core.Service;
import teka.web.referral_modulev0.repositories.core.HospitalLevelRepository;
import teka.web.referral_modulev0.repositories.core.ServiceRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class HospitalServicesService {

   @Autowired
   ServiceRepository serviceRepository;

   @Autowired
    HospitalLevelRepository hospitalLevelRepository;

    public List<Service> getAllServices(){

       return serviceRepository.findAll();

    }

    public Optional<Service> getServiceById(Long id){
        return serviceRepository.findById(id);
    }

    public List<Service> getHospitalServicesByLevel(int level){

        Optional<HospitalLevel> hospitalLevel = hospitalLevelRepository.findByLevel(level);
        return serviceRepository.findServicesByLevel(hospitalLevel);
    }
}
