package com.example.AnotherTry.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.example.AnotherTry.service.*.*(..))")
    public void selectAllServiceMethods() {
    }

    @Pointcut("execution(* com.example.AnotherTry.service.TransactionService.save(..))")
    public void selectUpdateMethod() {
    }

    @Pointcut("execution(* com.example.AnotherTry.service.TransactionService.delete(..))")
    public void selectDeleteMethod() {
    }

    @Before("selectAllServiceMethods()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Invocation of method " + joinPoint.getSignature());
    }

    @AfterReturning("selectUpdateMethod()")
    public void afterUpdating(JoinPoint joinPoint) {
        System.out.println("Table fields was updated " + Arrays.toString(joinPoint.getArgs()));
    }

    @Before("selectDeleteMethod()")
    public void beforeDeleting(JoinPoint joinPoint) {
        System.out.println("Trying delete fields from table");
    }
}
