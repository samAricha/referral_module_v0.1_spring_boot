package teka.web.referral_modulev0.controllers.referral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import teka.web.referral_modulev0.models.core.Hospital;
import teka.web.referral_modulev0.models.core.users.Patient;
import teka.web.referral_modulev0.models.core.users.Person;
import teka.web.referral_modulev0.models.core.users.Physician;
import teka.web.referral_modulev0.models.referral.Referral;
import teka.web.referral_modulev0.models.referral.ReferralStatus;
import teka.web.referral_modulev0.repositories.referral.ReferralRepository;
import teka.web.referral_modulev0.services.core.HospitalLevelService;
import teka.web.referral_modulev0.services.core.HospitalServicesService;
import teka.web.referral_modulev0.services.core.HospitalsService;
import teka.web.referral_modulev0.services.core.UsersService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/referral")
public class ReferralController {

    @Autowired
    HospitalServicesService hospitalServicesService;
    @Autowired
    HospitalsService hospitalsService;
    @Autowired
    HospitalLevelService hospitalLevelService;
    @Autowired
    UsersService usersService;
    @Autowired
    ReferralRepository referralRepository;

    @GetMapping("/trial")
    public String trial(){
        return "hospital_list";
    }



    @GetMapping("/all")
    public String getReferralList(Model model){
        List<Referral> referrals =  referralRepository.findAll();
        Collections.reverse(referrals);
        model.addAttribute("referrals", referrals);
        return "referral_list";

    }

    @GetMapping("/accept")
    public String acceptReferral(@RequestParam int referralId, Model model){

        Referral referral = referralRepository.findById((long) referralId).get();
        model.addAttribute(referral);

        return "records/accept_referral";
    }

    @PostMapping("/referral-coordinator/accept-decline-referral")
    public String updateReferral(@RequestParam Long referralId,
                                 @ModelAttribute("status") ReferralStatus status) {
        // Fetch the referral from the database using its ID
        Referral referral = referralRepository.findById(referralId).get();

        // Update the referral status
        referral.setStatus(status);

        // Save the updated referral to the database
        referralRepository.save(referral);

        // Redirect to different pages depending on the referral status
        if (status == ReferralStatus.ACCEPTED) {
            return "redirect:/referral/accepted";
        } else if (status == ReferralStatus.DECLINED) {
            return "redirect:/referral/all";
        }

        // If the status is neither accepted nor declined, redirect to the default page
        return "redirect:/referral/all";
    }




//    @PostMapping("/refer/{receiving_hospital_id}")
//    public String getHospital(@PathVariable int receiving_hospital_id, Model model){
//        //Optional<Person> person = usersService.getPersonById(Long.valueOf(161));
//        Optional<Patient> patient = usersService.getPatientById(1);
//
//        Optional<Physician> physician = usersService.getPhysicianById(31L);
//        Hospital referringHospital = physician.get().getHospital();
//        Optional<Hospital> receivingHospital = hospitalsService.getHospitalById(receiving_hospital_id);
//
//        Referral referral = new Referral();
//        referral.setPatient(patient.get());
//        referral.setReferringHospital(referringHospital);
//        referral.setReceivingHospital(receivingHospital.get());
//        referral.setStatus(ReferralStatus.PENDING);
//        referral.setReasonForReferral("CT-SCAN");
//
//        referralRepository.save(referral);
//        //add info to db
//        //send patient message
//
//        return "redirect:/";
//    }



}
