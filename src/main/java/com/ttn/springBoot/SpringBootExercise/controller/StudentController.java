package com.ttn.springBoot.SpringBootExercise.controller;

import com.ttn.springBoot.SpringBootExercise.Student;
import com.ttn.springBoot.SpringBootExercise.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

   @Autowired
   StudentService studentService;

   @RequestMapping("/getList")
   public List<Student> getStudents(){
       return  studentService.getStudentList();
   }
}