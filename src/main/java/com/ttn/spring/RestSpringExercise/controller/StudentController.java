package com.ttn.spring.RestSpringExercise.controller;


import com.ttn.spring.RestSpringExercise.Post;
import com.ttn.spring.RestSpringExercise.entity.Student;
import com.ttn.spring.RestSpringExercise.exception.StudentException;
import com.ttn.spring.RestSpringExercise.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;


@RestController
public class StudentController extends ResourceBundleMessageSource {

    @Autowired
    StudentService studentService;

    @Autowired
    MessageSource messageSource;

    @GetMapping("/saves")
    void saveList() {
        studentService.saveList();
    }

    @GetMapping("/students")
    List<Student> getStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/students/{id}")
    Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    //q2
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            throw new StudentException("the student you are trying to delete doesn't exists");
        } else {
            studentService.deleteStudent(student);
        }
    }

    //q3 and 5
   /* @PostMapping("/students")
    Student student(@RequestBody Student student) {
        studentService.saveStudent(student);
        return student;
    }*/

    //q3 n 5
    @PostMapping("/students")
    ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student){
        studentService.saveStudent(student);

        URI uri= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}").buildAndExpand(student.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    //q4
    @GetMapping("/")
    String hello() {
        System.out.println("hello");
//        System.out.println(locale.getLanguage());
        return messageSource.getMessage("greeting.message", null, LocaleContextHolder.getLocale());
    }

    //q8
    @GetMapping("/post")
    public String getPost() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response.getStatusCode().toString());
        System.out.println(response.getHeaders().toString());
        return response.getBody();
    }

    //read object
    @GetMapping("/postObject")
    public Post getPostObject() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        ResponseEntity<Post> response = restTemplate.getForEntity(url, Post.class);
        System.out.println(response.getStatusCode().toString());
        System.out.println(response.getHeaders().toString());
        return response.getBody();
    }

    //read list
    @GetMapping("/postList")
    public List<Post> getPostList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<List<Post>> response = restTemplate
                .exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Post>>() {
                        });
        return response.getBody();
    }

    @PostMapping("/createPost")
    public ResponseEntity<Post> createPost() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-type", "application/json; charset=UTF-8");
        HttpEntity<Post> request = new HttpEntity<>(new Post(10000L, 10000L, "title1", "description1"), httpHeaders);
        Post post = restTemplate.postForObject(url, request, Post.class);
        System.out.println(post);
        return new ResponseEntity<Post>(post, HttpStatus.CREATED);
    }

    @PutMapping("/updatePost")
    public ResponseEntity<Post> updatePost() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-type", "application/json; charset=UTF-8");
        HttpEntity<Post> request = new HttpEntity<>(new Post(105L, 100L, "title1", "description1"), httpHeaders);
        return restTemplate.exchange(url, HttpMethod.PUT, request, Post.class);
    }

    @DeleteMapping("/deletePost")
    public void deletePost() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-type", "application/json; charset=UTF-8");
        HttpEntity<Post> request = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(url, HttpMethod.DELETE, request, Post.class);
    }
}
