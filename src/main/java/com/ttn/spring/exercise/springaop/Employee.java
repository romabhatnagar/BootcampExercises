package com.ttn.spring.exercise.springaop;

import org.aspectj.lang.annotation.Pointcut;

import java.io.IOException;

class Employee {
    private String name;
    private int EmployeeId;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    void displayEmployeeDetails() {
        System.out.println("Employee Id is " + this.EmployeeId + " Name is: " + this.name + " Salary is " + this.salary);
    }

    void throwExcepion() throws Exception {
        throw new Exception();
    }

    void throwIOException() throws IOException {
        throw new IOException();
    }

    @Pointcut("execution(void displayEmployeeDetails())")
    void getStringPointcut() {
    }

}
