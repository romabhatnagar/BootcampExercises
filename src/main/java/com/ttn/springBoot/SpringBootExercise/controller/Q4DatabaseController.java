package com.ttn.springBoot.SpringBootExercise.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class Q4DatabaseController {
    @Value("${app.port}")
    private int port;
    @Value("${app.portname}")
    private String name;

    Q4DatabaseController(){

    }

    @RequestMapping("/getValues")
    public String  get()
    {
        return "Port Name is :"+name+" Number is"+port;
    }

    public Q4DatabaseController(int port, String name) {
        this.port = port;
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
}
