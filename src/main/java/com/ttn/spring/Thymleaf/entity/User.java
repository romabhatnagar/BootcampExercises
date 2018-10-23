package com.ttn.spring.Thymleaf.entity;

public class User {
    private Long id;
    private String name;
    private Boolean admin;
    private Double salary;

    public User() {
    }

    public User(Long id, String name, Boolean admin, Double salary) {
        this.id = id;
        this.name = name;
        this.admin = admin;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
