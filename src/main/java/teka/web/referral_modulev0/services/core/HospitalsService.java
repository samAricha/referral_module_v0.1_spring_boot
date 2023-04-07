package teka.web.referral_modulev0.services.core;

import org.springframework.beans.factory.annotation.Autowired;
import teka.web.referral_modulev0.dto.SubCountyDto;
import teka.web.referral_modulev0.models.core.Hospital;
import teka.web.referral_modulev0.models.core.HospitalLevel;
import teka.web.referral_modulev0.repositories.core.HospitalLevelRepository;
import teka.web.referral_modulev0.repositories.core.HospitalRepository;
import teka.web.referral_modulev0.repositories.core.ServiceRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class HospitalsService {

    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    UsersService usersService;
    @Autowired
    HospitalLevelRepository hospitalLevelRepository;
    @Autowired
    ServiceRepository serviceRepository;


    public List<Hospital> getAllHospitals(){
        return hospitalRepository.findAll();
    }

    public Optional<Hospital> getHospitalByWard(Long physicianId, int level){

        SubCountyDto ward = usersService.getPhysicianSubCounty(physicianId);
        Optional<HospitalLevel> hospitalLevel = hospitalLevelRepository.findByLevel(level);

        return hospitalRepository.findByLocationAndLevel(ward, hospitalLevel);

    }


    public List<Hospital> getHospitalByConstituency(Long physicianId, int level){
        Optional<HospitalLevel> hospitalLevel = hospitalLevelRepository.findByLevel(level);
        String constituency_name = usersService.getPhysicianSubCounty(physicianId).getConstituency_name();

     List<Hospital> hospitals = hospitalRepository.findByLevelAndLocation_ConstituencyName(hospitalLevel, constituency_name);

        return hospitals;

    }


    public List<Hospital> getHospitalByCounty(int level, Long physicianId) {
        // First find the county ID using the county name
        int countyId = usersService.getPhysicianSubCounty(physicianId).getCounty_id();
        Optional<HospitalLevel> hospitalLevel = hospitalLevelRepository.findByLevel(level);

        // Now find the hospital using the hospital level and county ID
        Optional<List<Hospital>> hospitals = hospitalRepository.findByLevelAndLocation_CountyId(hospitalLevel, countyId);

        return hospitals.get();

    }

    public Optional<Hospital> getHospitalById(int id) {

        return hospitalRepository.findById((long) id);

    }



}
