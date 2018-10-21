package com.ttn.spring.exercise.springaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContexte = new ClassPathXmlApplicationContext("employee.xml");
        Employee employee = applicationContexte.getBean("employee", Employee.class);
        Employee employee2 = applicationContexte.getBean("employee2", Employee.class);
        employee.displayEmployeeDetails();
        employee.getName();
        employee.getEmployeeId();
        employee.getSalary();
        employee.getInteger(100);
        // employee.throwExcepion();
        //employee.throwIOException();

        employee2.displayEmployeeDetails();
    }
}
