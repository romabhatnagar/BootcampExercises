package com.ttn.spring.exercise.springevent;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
class MyAspect {
    @Before("execution(void connect())")
    void beforeAdvice() {
        System.out.println("Before advice is running for connect method of database");
    }

    @AfterReturning(pointcut = "execution(Boolean closeConnection())", returning = "returnValue")
    void afterReturningAdvice(Boolean returnValue) {
        System.out.println("Running After Returning from close connection of database.. is database connection closed ??" + returnValue);
    }

    @AfterThrowing(pointcut = "execution(void throwException())", throwing = "ex")
    void afterReturningAdvice(Exception ex) {
        System.out.println("Running AfterThrowing " + ex);
    }

    @Around("execution(void connect())")
    void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around before\n");
        proceedingJoinPoint.proceed();
        System.out.println("Around after\n");
    }


}

