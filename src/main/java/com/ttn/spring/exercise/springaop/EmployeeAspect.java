package com.ttn.spring.exercise.springaop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@EnableAspectJAutoProxy
public class EmployeeAspect {

    @Before("execution(void displayEmployeeDetails())")
    void beforeAdvice() {
        System.out.println("Before advice is running ");
    }

    @After("execution(void displayEmployeeDetails())")
    void afterAdvice() {
        System.out.println("Aftrer advice is running ");
    }

    @AfterThrowing(pointcut = "execution(void throwException())", throwing = "ex")
    void afterReturningAdvice(Exception ex) {
        System.out.println("Running AfterThrowing " + ex);
    }

    @AfterReturning(pointcut = "execution(* com.ttn.spring.exercise.springaop.Employee.*())")
    void logAll() {
        System.out.println("logging all....");
    }

    @Before("execution(* com.ttn.spring.exercise.springaop.Employee.getName())")
    public void logBeforeGetName(JoinPoint joinPoint) {
        System.out.println("log before getName() : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.ttn.spring.exercise.springaop.Employee.getEmployeeId())")
    public void logBeforeGetEmployeeId(JoinPoint joinPoint) {
        System.out.println("log before getEmployeeId() : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.ttn.spring.exercise.springaop.Employee.getSalary())")
    public void logBeforeGetEmployeeName(JoinPoint joinPoint) {
        System.out.println("log before getSalary() : " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(void throwIOException())", throwing = "ex")
    void afterThrowingIO(Exception ex) {
        System.out.println("Running AfterThrowing " + ex);
    }

    @Before("bean(employee2))")
    void beforeAdviceEmployee() {
        System.out.println("Running before advice of employee2");
    }

    @Before("within(com.ttn.spring.exercise.springaop.*)")
    void before() {
        System.out.println("Running before advice from within");
    }

    @Before("this(com.ttn.spring.exercise.springaop.Employee)")
    void beforeRun() {
        System.out.println("Running before advice from this");
    }

    @After("bean(employee2))")
    void AfterAdviceEmployee() {
        System.out.println("Running before advice of employee2");
    }

    @After("within(com.ttn.spring.exercise.springaop.*)")
    void after() {
        System.out.println("Running before advice from within");
    }

    @After("this(com.ttn.spring.exercise.springaop.Employee)")
    void AfterRun() {
        System.out.println("Running before advice from this");
    }
}
