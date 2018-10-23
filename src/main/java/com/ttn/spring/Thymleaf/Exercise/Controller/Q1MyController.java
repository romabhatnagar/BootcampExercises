package com.ttn.spring.Thymleaf.Exercise.Controller;

import com.ttn.spring.Thymleaf.registrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@Controller
public class Q1MyController {

    @GetMapping("click")
    public String click() {
        return "Q1";
    }

    //  Question 2
    @GetMapping("style")
    public String style() {
        return "helloWorld";
    }

    //    Question 3
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistation() {
        return "registration";
    }

  /*  @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute(name = "registrationForm") registrationForm registrationForm, Model model) {
        String username = registrationForm.getUsername();
        String email = registrationForm.getEmail();
        String password = registrationForm.getPassword();
        System.out.println(username + "" + email + "" + password);
        if ("admin".equals(username) && "admin".equals(password)) {
            return "Home";
        } else if (!username.isEmpty()) {
            return "User";
        }
        model.addAttribute("invalidCredentials", true);
        return "registration";
    }*/

    //question 4
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String showDetails(@ModelAttribute(name = "userDetail") registrationForm registrationForm1, Model model) {
        return "Q4";
    }

    @GetMapping("Q8")
    public String showQ8() {
        return "Q8";
    }
}
