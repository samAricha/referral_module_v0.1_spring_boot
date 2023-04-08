package teka.web.referral_modulev0.controllers.core;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import teka.web.referral_modulev0.dto.PersonDto;
import teka.web.referral_modulev0.dto.ReferralInfoDto;
import teka.web.referral_modulev0.models.core.Hospital;
import teka.web.referral_modulev0.models.core.HospitalLevel;
import teka.web.referral_modulev0.models.core.Service;
import teka.web.referral_modulev0.models.core.Visit;
import teka.web.referral_modulev0.models.core.users.Patient;
import teka.web.referral_modulev0.models.core.users.Person;
import teka.web.referral_modulev0.models.core.users.Physician;
import teka.web.referral_modulev0.models.core.utils.Encounter;
import teka.web.referral_modulev0.models.referral.Referral;
import teka.web.referral_modulev0.models.referral.ReferralStatus;
import teka.web.referral_modulev0.repositories.core.VisitRepository;
import teka.web.referral_modulev0.repositories.core.users.PatientRepository;
import teka.web.referral_modulev0.repositories.core.utils.EncounterRepository;
import teka.web.referral_modulev0.repositories.referral.ReferralRepository;
import teka.web.referral_modulev0.services.core.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/physician")
public class PhysicianController {

    @Autowired
    HospitalsService hospitalsService;
    @Autowired
    HospitalLevelService hospitalLevelService;
    @Autowired
    HospitalServicesService hospitalServicesService;
    @Autowired
    UsersService usersService;
    @Autowired
    ReferralRepository referralRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    VisitRepository visitRepository;
    @Autowired
    EncounterRepository encounterRepository;
    @Autowired
    RecordsService recordsService;

    @GetMapping("")
    public String physician(Model model){
        List<Visit> visitList = recordsService.getVisitList();
        model.addAttribute("visitList", visitList);
        return "physician/patient_queue";
    }
    @GetMapping("/all")
    public List<Hospital> getHospitals(){
        return hospitalsService.getAllHospitals();
    }

    @GetMapping("/patients/patient-queue")
    public String patientQueue(Model model){
        List<Visit> visitList = recordsService.getVisitList();
        model.addAttribute("visitList", visitList);
        return "physician/patient_queue";
    }


    //search services page with hospital levels
    @GetMapping("/search")
    public String searchServices(@RequestParam("visitId") Long visitId,Model model) {
        Visit visit = visitRepository.findById(visitId).get();
        Person person = usersService.getPersonById(visit.getPerson().getId()).get();
        List<HospitalLevel> levels = hospitalLevelService.getAllHospitalLevels();
        Encounter encounter = new Encounter();
        //this is the clicked patient
        Patient patient = usersService.getPatientByPersonId(visit.getPerson().getId());
        //this is supposed to be the logged in physician
        Physician physician = usersService.getPhysicianById(1L).get();
        encounter.setPatient(patient);
        encounter.setPhysician(physician);
        encounter.setHospital(visit.getSecretary().getHospital());
        encounter.setVisit(visit);
        encounterRepository.save(encounter);
        
        model.addAttribute("levels", levels);
        model.addAttribute("person", person);

        return "/physician/search_service";
    }

    //returns a list of services depending on hospital level
    @GetMapping("/hospital-services")
    public ResponseEntity<List<Service>> filterServicesByLevel(@RequestParam int level) {
        List<Service> services = hospitalServicesService.getHospitalServicesByLevel( level);
        return ResponseEntity.ok(services);
    }


    @GetMapping("/referral-list")
    public String getAppropriateLevelHospital(@RequestParam int hospital_level, @RequestParam int person_id, Model model){
        List<Hospital> hospitals = new ArrayList<>();
        if(hospital_level == 1){
            //NB: the physician id is supposed to be gotten from session, in our case its 2L
            // return hospitalsService.getHospitalByWard(2L, hospital_level);
            hospitals =  hospitalsService.getHospitalByConstituency(1L, 2);

        }else if(hospital_level == 2){

            hospitals =  hospitalsService.getHospitalByConstituency(1L, 2);

        }else if(hospital_level == 3){

            hospitals =  hospitalsService.getHospitalByConstituency(1L, 2);

        }
        else if(hospital_level == 4){

            hospitals = hospitalsService.getHospitalByCounty(2, 1L);

        } else if (hospital_level == 5) {

            hospitals = hospitalsService.getHospitalByCounty(2, 1L);

        }else if(hospital_level == 6){

            hospitals = hospitalsService.getHospitalByCounty(2, 1L);

        }


        model.addAttribute("person", usersService.getPersonById((long) person_id).get());
        model.addAttribute("hospitals", hospitals);
        return "physician/hospital_list";
    }

    @GetMapping("referral/hospital")
    public String getReferringHospital(@RequestParam int hospital_id, @RequestParam int person_id, Model model){


        ReferralInfoDto referralInfoDto = new ReferralInfoDto();
        //Optional<Patient> patient = usersService.getPatientById(1L);
        Patient patient = patientRepository.findOneByPersonId((long) person_id);

        Optional<Hospital> hospital =  hospitalsService.getHospitalById(hospital_id);
        referralInfoDto.setPatient(patient);
        referralInfoDto.setReceivingHospital(hospital.get());
        model.addAttribute("referralInfoDto", referralInfoDto);
//        model.addAttribute("hospital", hospital);
//        model.addAttribute("patient", patient);
        return "/physician/refer_patient";
    }



    @PostMapping("referral/refer")
    public String getHospital(@ModelAttribute("referralInfoDto") ReferralInfoDto referralInfoDto){
        //THIS IS MANUAL AND THEREFORE SHOULD BE FIXED
        Optional<Patient> patient = usersService.getPatientById(20);
        //Patient patient = referralInfoDto.getPatient();

        Optional<Physician> physician = usersService.getPhysicianById(1L);
        //Physician physician = referralInfoDto.getReferringPhysician();
        Hospital referringHospital = physician.get().getHospital();
        Optional<Hospital> receivingHospital = hospitalsService.getHospitalById(1);
        //Hospital receivingHospital = referralInfoDto.getReceivingHospital();
        Referral referral = new Referral();
        referral.setPatient(patient.get());
        referral.setReferringHospital(referringHospital);
        referral.setReceivingHospital(receivingHospital.get());
        referral.setStatus(ReferralStatus.PENDING);
        referral.setReasonForReferral("X-RAY");

        referralRepository.save(referral);
        //add info to db
        //send patient message

        return "redirect:/referral/all";

    }
}
