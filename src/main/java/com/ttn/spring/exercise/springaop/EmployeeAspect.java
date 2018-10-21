package com.ttn.spring.exercise.springaop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@EnableAspectJAutoProxy
public class EmployeeAspect {

    //Question 9
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

    //Question 1
    @Before("execution(* com.ttn.spring.exercise.springaop.Employee.getName())")
    public void logBeforeGetName(JoinPoint joinPoint) {
        System.out.println("log before getName() : " + joinPoint.getSignature().getName());
    }

    //Question 2
    @Before("execution(* com.ttn.spring.exercise.springaop.Employee.getEmployeeId())")
    public void logBeforeGetEmployeeId(JoinPoint joinPoint) {
        System.out.println("log before getEmployeeId() : " + joinPoint.getSignature().getName());
    }

    //Question 2
    @After("execution(* com.ttn.spring.exercise.springaop.Employee.getEmployeeId())")
    public void logAfterGetEmployeeId(JoinPoint joinPoint) {
        System.out.println("log after getEmployeeId() : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.ttn.spring.exercise.springaop.Employee.getSalary())")
    public void logBeforeGetEmployeeName(JoinPoint joinPoint) {
        System.out.println("log before getSalary() : " + joinPoint.getSignature().getName());
    }

    //Question 3
    @AfterThrowing(pointcut = "execution(void throwIOException())", throwing = "ex")
    void afterThrowingIO(Exception ex) {

        System.out.println("Running AfterThrowing " + ex);
    }

    //Question 4
    @Before("bean(employee2))")
    void beforeAdviceEmployee() {

        System.out.println("Running before advice of employee2");
    }

    //Question 4
    @Before("within(com.ttn.spring.exercise.springaop.*)")
    void before() {

        System.out.println("Running before advice from within");
    }

    //Question 4
    @Before("this(com.ttn.spring.exercise.springaop.Employee)")
    void beforeRun() {

        System.out.println("Running before advice from this");
    }

    //Question 4
    @After("bean(employee2))")
    void AfterAdviceEmployee() {

        System.out.println("Running before advice of employee2");
    }

    //Question 4
    @After("this(com.ttn.spring.exercise.springaop.Employee)")
    void AfterRun() {

        System.out.println("Running before advice from this");
    }


    @Pointcut("execution(public void display())")
    public void displayPointCut() {
        System.out.println("hii");
    }


    @Before("displayPointCut()")
    public void runningAfterDisplayPointCut() {

        System.out.println("running After Display PointCut");
    }

    //Q6
    @Before("execution(Integer getInteger(Integer))")
    void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("---------------------");
        System.out.println("Running before advice in JoinPoint");
        System.out.println(joinPoint);
        System.out.println("get this " + joinPoint.getThis());
        System.out.println("get signature " + joinPoint.getSignature());
        Object[] objects = joinPoint.getArgs();
        for (Object object : objects) {
            System.out.println(object);
        }
        System.out.println("----------");
    }
}
