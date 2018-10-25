package com.ttn.spring.RestSpringExercise.repository;

import com.ttn.spring.RestSpringExercise.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface studentRepository extends CrudRepository<Student, Integer> {

}
