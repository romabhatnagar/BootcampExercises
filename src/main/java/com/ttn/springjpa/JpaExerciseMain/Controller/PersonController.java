package com.ttn.springjpa.JpaExerciseMain.Controller;

import com.ttn.springjpa.JpaExerciseMain.entity.Person;
import com.ttn.springjpa.JpaExerciseMain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
//q 1,2,3
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/saveList")
    public void savePersonList() {
        personService.createList();
    }

    @GetMapping("/get/{id}")
    public Person getPerson(@PathVariable int id) {
        return personService.getPerson(id);
    }

    @GetMapping("/getPersons")
    public List<Person> getList() {
        return (List<Person>) personService.getPersonList();
    }


    @GetMapping("/delete/{id}")
    public void deletPerson(@PathVariable int id) {
        personService.deletePerson(id);
    }

    @GetMapping("/update/{id}")
    public void updatePerson(@PathVariable int id) {
        personService.updatePerson(id);
    }

    //    ----q4- nd q5-----
    @GetMapping("/findByLName/{name}")
    public List<Person> findByLname(@PathVariable String name) {
        return personService.findByLName(name);
    }

   /* @GetMapping("/findByFName/{name}")
    public List<Person> findByFname(@PathVariable String name){
        return personService.findByFName(name);
    }*/

    @GetMapping("/findById/{id}")
    public Person find(@PathVariable int id) {
        return personService.findById(id);
    }

    //    ----q6 Use @Query to fetch firstname of the Person whose age is 25.--
    @GetMapping("/findByAge/{id}")
    public Optional<Person> findbyAge(@PathVariable int id) {
        return personService.findByAge(id);
    }

    //    ----q7 Use @Query to fetch firstname and lastname of the Person whose age is 25.---
    @GetMapping("/find/{age}")
    public List<Person> findPerson(@PathVariable int age) {
        return personService.findPersonByAge(age);
    }

    //    -----q8 Get complete information of the Employee whose age is 25 using @Query.---
    @GetMapping("/getData/{id}")
    public Person getDetails(@PathVariable int id) {
        return personService.getPerson(id);
    }

    //   ----q9 Count Person where name is "Peter" using @Query.--------
    @GetMapping("/count/{name}")
    public Integer countPerson(@PathVariable String name) {
        return personService.count(name);
    }

    //    ----q10 -----
    //distinct
    @GetMapping("/findDistinctByName/{name}")
    public Person findDistinctName(@PathVariable String name) {
        return personService.findDistinct(name);
    }

    //or
    @GetMapping("/findPerson/{name}/{id}")
    public List<Person> findByNameOrId(@PathVariable String name, @PathVariable int age) {
        return personService.findByAgeOrId(name, age);
    }

    //and

    //between

    //LessThan

    //GreaterThan

    //Like

    //Not

    //In

    //IgnoreCase

//    ---q11--
//    ----q12--
   /* @GetMapping("/sort/{name}")
    public List<Person> sort(@PathVariable String name){
        return personService.sort(name);
    }
*/
//    --q13--
}
