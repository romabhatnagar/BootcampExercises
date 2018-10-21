package com.ttn.springBoot.SpringBootExercise.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoggerController {
    Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @RequestMapping("/logging")
    public String index()
    {
         logger.debug("ok debugging the code");
        return "trace is printed";
    }

}
