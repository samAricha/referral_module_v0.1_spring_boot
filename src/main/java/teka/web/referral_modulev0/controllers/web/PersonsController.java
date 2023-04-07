package teka.web.referral_modulev0.controllers.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/persons")
public class PersonsController {

    @GetMapping("/registration")
    public String registration() {

        return "auth/register_person";
    }

}
