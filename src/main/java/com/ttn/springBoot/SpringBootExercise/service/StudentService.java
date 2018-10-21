package com.ttn.springBoot.SpringBootExercise.service;

import com.ttn.springBoot.SpringBootExercise.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudentList(){
        return Arrays.asList(new Student("roma",1,23), new Student("ria",2,32));
    }
}
