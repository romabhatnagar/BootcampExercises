package com.ttn.spring.RestSpringExercise.service;

import com.ttn.spring.RestSpringExercise.entity.Student;
import com.ttn.spring.RestSpringExercise.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private studentRepository studentRepository;

    public List<Student> getAllStudent() {
        return (List<Student>) studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        Optional<Student> optional = studentRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void saveList() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student("roma" + i, i, 22 + i, "delhi", 90.6f);
            students.add(student);
        }
        studentRepository.saveAll(students);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

}
