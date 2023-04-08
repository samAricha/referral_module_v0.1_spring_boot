package teka.web.referral_modulev0.controllers.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import teka.web.referral_modulev0.dto.PatientDto;
import teka.web.referral_modulev0.dto.PersonDto;
import teka.web.referral_modulev0.dto.PhysicianDto;
import teka.web.referral_modulev0.dto.SecretaryDto;
import teka.web.referral_modulev0.models.core.Hospital;
import teka.web.referral_modulev0.models.core.Visit;
import teka.web.referral_modulev0.models.core.enums.VisitStatus;
import teka.web.referral_modulev0.models.core.enums.VisitType;
import teka.web.referral_modulev0.models.core.users.Patient;
import teka.web.referral_modulev0.models.core.users.Person;
import teka.web.referral_modulev0.models.core.users.Physician;
import teka.web.referral_modulev0.models.core.utils.Encounter;
import teka.web.referral_modulev0.repositories.core.users.PatientRepository;
import teka.web.referral_modulev0.repositories.core.users.PersonRepository;
import teka.web.referral_modulev0.services.core.EncounterService;
import teka.web.referral_modulev0.services.core.HospitalsService;
import teka.web.referral_modulev0.services.core.RecordsService;
import teka.web.referral_modulev0.services.core.UsersService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/secretary")
public class SecretaryController {

    @Autowired
    EncounterService encounterService;
    @Autowired
    UsersService usersService;
    @Autowired
    RecordsService recordsService;
    @Autowired
    HospitalsService hospitalsService;
    @Autowired
    PersonRepository personRepository;


    @GetMapping("/check-in")
    public String checkIn(){

        return "secretary/check_in";

    }
    @GetMapping("/check-in/registration/patient-registration")
    public String patientRegistration(Model model){
        model.addAttribute("personDto", new PersonDto());
        model.addAttribute("patientDto", new PatientDto());
        return "secretary/register_patient";

    }
    @GetMapping("/check-in/registration/secretary-registration")
    public String secretaryRegistration(Model model){
        model.addAttribute("personDto", new PersonDto());
        model.addAttribute("secretaryDto", new SecretaryDto());
        return "secretary/register_secretary";

    }

    @GetMapping("/check-in/registration/physician-registration")
    public String physicianRegistration(Model model){
        model.addAttribute("personDto", new PersonDto());
        model.addAttribute("physicianDto", new PhysicianDto());
        return "secretary/register_physician";

    }

    @PostMapping("/patient-intake/{patientId}")
    public String register(@PathVariable int patientId){

        Encounter encounter = new Encounter();
        Optional<Patient> patient = usersService.getPatientById(patientId);
        Optional<Physician> physician = usersService.getPhysicianById(Long.valueOf(1));
        Optional<Hospital> hospital = hospitalsService.getHospitalById(1);

        encounter.setPatient(patient.get());
        encounter.setPhysician(physician.get());
        encounter.setHospital(hospital.get());

        // Save encounter
        encounterService.saveEncounter(encounter);

        return "index";
    }


    @GetMapping("/check-in/patients/start-visit")
    public String startEncounter(){

        return "secretary/start_visit";

    }


    @GetMapping("/check-in/patients/search")
    public ResponseEntity<Person> searchPatients(@RequestParam("term") String query) {

        Person person = personRepository.findByIdNumber(Integer.parseInt(query));
        //List<Person> persons = personRepository.findByIdNumberContainingIgnoreCaseOrUsernameContainingIgnoreCase(query, query);
        //model.addAttribute("patient", person);
        return ResponseEntity.ok().body(person);
    }

    @PostMapping("/check-in/patients/add-to-queue")
    public ResponseEntity<Map<String, String>> addPatientToQueue(@RequestBody Person personToQueue){

        // Process the personToQueue object
        System.out.println(personToQueue.getUsername()+" UserHere!!");
        Visit visit = new Visit();
        visit.setSecretary(usersService.getSecretaryById(1).get());
        visit.setPerson(personToQueue);
        visit.setVisitType(VisitType.UNSCHEDULED);
        visit.setVisitStatus(VisitStatus.CHECKED_IN);


        recordsService.createVisit(visit);

        // Create a JSON response object
        Map<String, String> response = new HashMap<>();
        response.put("status", "Success");

        return ResponseEntity.ok().body(response);

    }
}
