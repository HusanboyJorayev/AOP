package org.example.aop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AopConfiguration {

    @Pointcut("execution(* org.example.aop.demo.*.*(..))")
    public void loggingJoinPoint() {
    }

    @Before("loggingJoinPoint()")
    public void before(JoinPoint joinPoint) {
        log.info("Before method invoked.{}", joinPoint.getSignature().getName());
    }

    @After("loggingJoinPoint()")
    public void after(JoinPoint joinPoint) {
        log.info("After method invoked.{}", joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "loggingJoinPoint()", throwing = "e")
    public void throwException(JoinPoint joinPoint, Exception e) {
        log.info("Throw exception method invoked.{}", e.getMessage());
    }

    @AfterReturning("loggingJoinPoint()")
    public void afterReturning(JoinPoint joinPoint) {
        log.info("After returning method invoked.{}", joinPoint.getSignature().getName());
    }
}
