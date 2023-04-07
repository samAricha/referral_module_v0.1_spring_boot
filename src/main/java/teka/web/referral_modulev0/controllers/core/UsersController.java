package teka.web.referral_modulev0.controllers.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import teka.web.referral_modulev0.dto.SubCountyDto;
import teka.web.referral_modulev0.models.core.Hospital;
import teka.web.referral_modulev0.models.core.users.Patient;
import teka.web.referral_modulev0.models.core.users.Person;
import teka.web.referral_modulev0.models.core.users.Physician;
import teka.web.referral_modulev0.models.core.users.Secretary;
import teka.web.referral_modulev0.repositories.core.users.PatientRepository;
import teka.web.referral_modulev0.repositories.core.users.PersonRepository;
import teka.web.referral_modulev0.services.core.UsersService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/physicians")
    public List<Physician> getAllPhysicians(){
        return usersService.getAllPhysicians();
    }

    @GetMapping("/secretaries")
    public List<Secretary> getAllSecretaries(){
        return usersService.getAllSecretaries();
    }

    @GetMapping("/physician/{id}/location")
    public SubCountyDto getPhysicianLocation(@PathVariable Long id){

       return usersService.getPhysicianSubCounty(id);

    }



}
