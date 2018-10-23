package com.ttn.spring.Thymleaf.Controller.sessiondemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

    @GetMapping("/sayHello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/test")
    ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("var", "true");
        return modelAndView;
    }

}
