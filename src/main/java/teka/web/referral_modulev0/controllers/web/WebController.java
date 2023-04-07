package teka.web.referral_modulev0.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WebController {

    @GetMapping("home")
    public String index(Model model) {

        return "index";
    }

    @GetMapping("/test")
    public String trial(Model model) {

        return "test_page";
    }


}
