package com.ttn.springjpa.JpaExerciseMain.service;

import com.ttn.springjpa.JpaExerciseMain.entity.Person;
import com.ttn.springjpa.JpaExerciseMain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    //get single person
    public Person getPerson(int id) {
        return personRepository.findById(id);
    }

    //get list of persons
    public Iterable<Person> getPersonList() {
        return personRepository.findAll();
    }

    //update
    public void updatePerson(int id) {
        Person person = personRepository.findById(id);
        person.setAge(20);
        personRepository.save(person);
    }

    //create
    public void createList() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            Person person = new Person("roma" + i, "bhatnagar" + i, 2000 * (i * 5), 20 + i);
            personList.add(person);
            personRepository.saveAll(personList);
        }
    }

//    ----q4------

    //delete
    public void deletePerson(int id) {
        Person person = personRepository.findById(id);
        personRepository.delete(person);
    }

    //findByLName
    public List<Person> findByLName(String name) {
        return personRepository.findByLastName(name);
    }

    //findByFName
//    public List<Person> findByFName(String name){
//        return personRepository.findByFirstName(name);
//    }

    //findById
    public Person findById(@PathVariable int id) {
        return personRepository.findById(id);
    }

    //findage
    public Optional<Person> findByAge(@PathVariable int age) {
        return personRepository.findByFirstName(age);
    }

    public List<Person> findPersonByAge(int id) {
        return personRepository.find(id);
    }

    public Person getData(int id) {
        return personRepository.findPerson(id);
    }

    public Integer count(String name) {
        return personRepository.countByFirstName(name);
    }

    public Person findDistinct(String name) {
        return personRepository.findDistinctByFirstName(name);
    }

    public List<Person> findByAgeOrId(String name, int id) {
        return personRepository.findByFirstNameOrId(name, id);
    }

   /* public List<Person> sort(String name){
        return personRepository.findByFirstNameOrderByIdDesc(name);
    }*/
}
