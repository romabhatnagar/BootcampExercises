package com.ttn.spring.RestSpringExercise.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    public int getId() {
        return id;
    }

    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
    private int standard;
    private int age;
    private String city;
    private float percentage;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public Student(String name, int standard, int age, String city, float percentage) {
        this.name = name;
        this.standard = standard;
        this.age = age;
        this.city = city;
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", standard=" + standard +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
