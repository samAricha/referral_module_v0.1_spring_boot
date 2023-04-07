package teka.web.referral_modulev0.controllers.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import teka.web.referral_modulev0.dto.PatientDto;
import teka.web.referral_modulev0.dto.PersonDto;
import teka.web.referral_modulev0.models.core.users.Patient;
import teka.web.referral_modulev0.models.core.users.Person;
import teka.web.referral_modulev0.models.core.utils.Encounter;
import teka.web.referral_modulev0.services.core.EncounterService;
import teka.web.referral_modulev0.services.core.UsersService;

import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    EncounterService encounterService;
    @Autowired
    UsersService usersService;

    @GetMapping("/registration")
    public String index(Model model){
        model.addAttribute("personDto", new PersonDto());
        model.addAttribute("patientDto", new PatientDto());
        return "auth/register_patient";
    }

//    @PostMapping("/register")
//    public String register(@ModelAttribute("personDto") PersonDto personDto,
//                           @ModelAttribute("patientDto") PatientDto patientDto
//    ){
//
//
//        // Map PersonDto to Person entity
//
//        Person person = new Person();
//        person.setUsername(personDto.getUsername());
//        person.setIdNumber( Integer.parseInt(personDto.getIdNumber()));
//        person.setPhone(Integer.parseInt(personDto.getPhone()));
//        person.setGender(personDto.getGender());
//
//        // Save Person entity
//        Person savedPerson = usersService.savePerson(person);
//
//        // Map PatientDto to Patient entity
//        Patient patient = new Patient();
//        patient.setPerson(savedPerson);
//        patient.setBloodType(patientDto.getBloodType());
//        patient.setAllergies(patientDto.getAllergies());
//
//        // Save Patient entity
//        usersService.savePatient(patient);
//
//        return "index";
//    }


}
