package teka.web.referral_modulev0.controllers.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import teka.web.referral_modulev0.dto.PatientDto;
import teka.web.referral_modulev0.dto.PersonDto;
import teka.web.referral_modulev0.dto.PhysicianDto;
import teka.web.referral_modulev0.models.core.Hospital;
import teka.web.referral_modulev0.models.core.users.Patient;
import teka.web.referral_modulev0.models.core.users.Person;
import teka.web.referral_modulev0.models.core.users.Physician;
import teka.web.referral_modulev0.models.core.users.Secretary;
import teka.web.referral_modulev0.models.core.utils.Encounter;
import teka.web.referral_modulev0.services.core.HospitalLevelService;
import teka.web.referral_modulev0.services.core.HospitalsService;
import teka.web.referral_modulev0.services.core.UsersService;

import java.util.Optional;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    UsersService usersService;
    @Autowired
    HospitalsService hospitalsService;

    @PostMapping("/patient")
    public String registerPatient(@ModelAttribute("personDto") PersonDto personDto,
                           @ModelAttribute("patientDto") PatientDto patientDto
    ){


        // Map PersonDto to Person entity

        Person person = new Person();
        person.setUsername(personDto.getUsername());
        person.setIdNumber( Integer.parseInt(personDto.getIdNumber()));
        person.setPhone(Integer.parseInt(personDto.getPhone()));
        person.setGender(personDto.getGender());

        // Save Person entity
        Person savedPerson = usersService.savePerson(person);

        // Map PatientDto to Patient entity
        Patient patient = new Patient();
        patient.setPerson(savedPerson);
        patient.setBloodType(patientDto.getBloodType());
        patient.setAllergies(patientDto.getAllergies());

        // Save Patient entity
        usersService.savePatient(patient);

        return "index";
    }

    @PostMapping("/physician")
    public String registerPhysician(@ModelAttribute("personDto") PersonDto personDto,
                           @ModelAttribute("patientDto") PhysicianDto physicianDto
    ){

        //this is the hospital where the registration is taking place
        Optional<Hospital> hospital =  hospitalsService.getHospitalById(1);

        // Map PersonDto to Person entity

        Person person = new Person();
        person.setUsername(personDto.getUsername());
        person.setIdNumber( Integer.parseInt(personDto.getIdNumber()));
        person.setPhone(Integer.parseInt(personDto.getPhone()));
        person.setGender(personDto.getGender());

        // Save Person entity
        Person savedPerson = usersService.savePerson(person);

        // Map PatientDto to Patient entity
        Physician physician = new Physician();
        physician.setPerson(savedPerson);
        physician.setHospital(hospital.get());
        physician.setSpeciality(physicianDto.getSpecialty());


        // Save Patient entity
        usersService.savePhysician(physician);

        return "index";
    }

    @PostMapping("/secretary")
    public String registerSecretary(@ModelAttribute("personDto") PersonDto personDto,
                           @ModelAttribute("patientDto") PatientDto patientDto
    ){
        //this is the hospital where the registration is taking place
        Optional<Hospital> hospital =  hospitalsService.getHospitalById(1);

        // Map PersonDto to Person entity
        Person person = new Person();
        person.setUsername(personDto.getUsername());
        person.setIdNumber( Integer.parseInt(personDto.getIdNumber()));
        person.setPhone(Integer.parseInt(personDto.getPhone()));
        person.setGender(personDto.getGender());

        // Save Person entity
        Person savedPerson = usersService.savePerson(person);


        // Map PhysicianDto to Physician entity
        Secretary secretary = new Secretary();
        secretary.setPerson(savedPerson);
        secretary.setHospital(hospital.get());


        // Save Patient entity
        usersService.saveSecretary(secretary);

        return "index";
    }
}
