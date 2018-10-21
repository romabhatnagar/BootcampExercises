package com.ttn.springBoot.SpringBootExercise.controller;

import com.ttn.springBoot.SpringBootExercise.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    User user;
    @RequestMapping("/getUser")
    public User getUser()
    {
        return user;
    }
}
