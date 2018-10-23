package com.ttn.spring.Thymleaf.Controller;

import com.ttn.spring.Thymleaf.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ExerciseController {

    @Autowired
    private Employee employee;

    //question 1
    @GetMapping("/question1")
    public String alertThrowing() {
        return "layouts/exercise";
    }

    //question 3 and 5
    @GetMapping("/register")
    public String employeeRegister(Employee employee) {
        return "layouts/register";
    }

    //Q4
    @PostMapping("/employeesubmit")
    public String getEmployeedetails(@ModelAttribute("employee") Employee employee, Model model) {
        System.out.println("**");
        System.out.println(employee);
        System.out.println("**");
        //employee.setAdmin(true);
        return "layouts/employee";
    }

    //q10
    @GetMapping("/loader")
    public String register(Employee employee) {
        return "layouts/loader";
    }

    //q7
    @GetMapping("/serverTime")
    public String showServerTime() {
        return "layouts/serverTime";
    }

}
