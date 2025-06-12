package com.home.practice.spring_review_v1.Aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimeTraceAOP {

    @Around("execution(* com.home.practice.spring_review_v1..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        Long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try{
            return joinPoint.proceed();
        }finally {
            Long end = System.currentTimeMillis();
            Long result = end - start;
            System.out.println("END : " + joinPoint.toString() + result + " 초");
        }
    }
}
