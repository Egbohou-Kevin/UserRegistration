package com.supra.entretien.ClientRegister.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.demo.*.*(..))")
    public Object logMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        logger.info("Method {} - Arguments: {}", joinPoint.getSignature(), joinPoint.getArgs());

        Object result = joinPoint.proceed();

        long elapsedTime = System.currentTimeMillis() - startTime;
        logger.info("Method {} - Result: {} - Execution time: {} ms", joinPoint.getSignature(), result, elapsedTime);

        return result;
    }
}
