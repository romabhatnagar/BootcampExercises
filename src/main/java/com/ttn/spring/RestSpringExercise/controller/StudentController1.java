package com.ttn.spring.RestSpringExercise.controller;

import com.ttn.spring.RestSpringExercise.version.Name;
import com.ttn.spring.RestSpringExercise.version.StudentV1;
import com.ttn.spring.RestSpringExercise.version.StudentV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController1 {

    //URI Versioning
    @GetMapping("/students/V1")
    StudentV1 getStudentV1() {
        return new StudentV1("roma bhatmagar");
    }

    @GetMapping("/students/V2")
    StudentV2 getStudentV2() {
        return new StudentV2(new Name("roma","bhatnagar"));
    }

    //Parameter Versioning
    @GetMapping(value = "/students/param", params = "version=1")
    StudentV1 getStudentParam1() {
        return new StudentV1("R bhatagar");
    }


    @GetMapping(value = "/students/param", params = "version=2")
    StudentV2 getStudentParam2() {
        return new StudentV2(new Name("ria","bhatnagar"));
    }

    //Header Versioning
    //API-VERSION 1 header required with request
    @GetMapping(value = "/students/header", headers = "API-VERSION=1")
    StudentV1 getStudentHeader1() {
        return new StudentV1("abc xyz");
    }

    @GetMapping(value = "/students/header", headers = "API-VERSION=2")
    StudentV2 getStudentHeader2() {
          return new StudentV2(new Name("Peter","Parker"));
    }

    //Mime Type/Content Negotiation/Accept Header Versioning
    //Accept application/app-v1+json header required with request
    @GetMapping(value = "/students/produces", produces = "application/app-v1+json")
    StudentV1 getStudentProducer1() {
        return new StudentV1("Peter Parker");
    }

    @GetMapping(value = "/students/produces", produces = "application/app-v2+json")
    StudentV2 getStudentProducer2() {
        return new StudentV2(new Name("Peter","Parker"));
    }
}
