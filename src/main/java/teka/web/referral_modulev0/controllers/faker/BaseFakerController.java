package teka.web.referral_modulev0.controllers.faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teka.web.referral_modulev0.services.faker.CoreFakePersonsDataService;
import teka.web.referral_modulev0.services.faker.FakeHospitalDataService;


@RestController
@RequestMapping("/fake")
public class BaseFakerController {

    @Autowired
    private FakeHospitalDataService fakeHospitalDataService;
    @Autowired
    private CoreFakePersonsDataService coreFakePersonsDataService;


    @GetMapping("test")
    public String test() {


        return "Working Correctly";
    }


    @GetMapping("hospitals")
    public String home() {

        fakeHospitalDataService.generateFakeData(45);

        return "data generated";
    }


    @GetMapping("persons")
    public String core() {

        coreFakePersonsDataService.generateFakeData();

        return "data generated";
    }
}
