
package com.ttn.springjpa.JpaExerciseMain.repository;

import com.ttn.springjpa.JpaExerciseMain.entity.Person;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findByLastName(String name);

    //    List<Person> findByFirstName(String name);
    Person findById(int id);

    @Query("select firstName from Person where age=:age")
    Optional<Person> findByFirstName(@Param("age") int age);

    @Query("select firstName,lastName from Person where age= :age")
    List<Person> find(@Param("age") int age);

    @Query("select firstName,lastName,age,salary from Person where age= :age")
    Person findPerson(@Param("age") int age);

    @Query(value = "select count(*) from Person  where firstName = :name")
    Integer countByFirstName(@Param("name") String name);

    Person findDistinctByFirstName(String name);

    List<Person> findByFirstNameOrId(String name, int id);

    @Query("select firstName, lastName from Person  where age >25")
    List<Person> findByAgeOrderByIdDesc(int age);
}
