package com.ttn.springmvc.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/Student")
public class StudentController {
    private int id;
    private String name;
    private int age;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @ModelAttribute()
    public ModelAndView testmE() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message", "SPRING MVC DEMO");
        return modelAndView;
    }

    @RequestMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("message", "Hello world from Test");
        return modelAndView;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public void sayHello(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setContentType("text/html");
        httpServletResponse.getWriter().println("<b>HELLO World</b>");
    }

    @RequestMapping("/fill")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("form");
        return modelAndView;
    }

    @RequestMapping("/test2/{id}/{age}/{name}")
    public ModelAndView test3(@PathVariable Long id, @PathVariable Map<String, String> map) {
        ModelAndView modelAndView = new ModelAndView("studentData");
        modelAndView.addObject("id", id);
        modelAndView.addObject("name", map.get("name"));
        modelAndView.addObject("age", map.get("age"));
        return modelAndView;
    }


    @RequestMapping("/submit")
    public ModelAndView submitForm(@ModelAttribute("studentDTO") @Valid StudentCO studentCO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("index");
        }
        return new ModelAndView("submittedForm");
    }

    @RequestMapping(value = "/submitForm", method = RequestMethod.POST)
    @ResponseBody
    String submitForm(@RequestParam("name") String name,
                      @RequestParam("age") String age,
                      @RequestParam("id") String id) {
        return "Name " + name + " age  " + age + "id " + id;
    }
}
