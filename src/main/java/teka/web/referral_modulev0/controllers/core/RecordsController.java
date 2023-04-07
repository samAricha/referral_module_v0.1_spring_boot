package teka.web.referral_modulev0.controllers.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import teka.web.referral_modulev0.models.core.Hospital;
import teka.web.referral_modulev0.models.core.Visit;
import teka.web.referral_modulev0.services.core.RecordsService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/records")
public class RecordsController {

    @Autowired
    RecordsService recordsService;

    @GetMapping("")
    public String recordsHomePage(Model model){

        List<Visit> visitList = recordsService.getVisitList();
        model.addAttribute("visitList", visitList);
//        return "/records/patient_queue";
        return "/records/records_choice";

    }

    @GetMapping("/visit-list")
    public String getAppropriateLevelHospital(Model model){

        List<Visit> visitList = recordsService.getVisitList();
        model.addAttribute("visitList", visitList);
//        return "/records/patient_queue";
        return "/records/patient_queue";

    }

}
