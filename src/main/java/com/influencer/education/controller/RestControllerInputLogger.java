package com.influencer.education.controller;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class RestControllerInputLogger {

    private static final Logger logger = LoggerFactory.getLogger(RestControllerInputLogger.class);

    // Before: Log input arguments
    @Before("execution(* com.influencer.education.controller..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        String arguments = Arrays.toString(joinPoint.getArgs());

        logger.info("Executing method: {} with arguments: {}", methodName, arguments);
    }

    // AfterReturning: Log result
    @AfterReturning(pointcut = "execution(* com.influencer.education.controller..*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();

        logger.info("Method: {} executed successfully with result: {}", methodName, result);
    }

    // AfterThrowing: Log exception
    @AfterThrowing(pointcut = "execution(* com.influencer.education.controller..*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();

        logger.error("Method: {} threw an exception: {}", methodName, exception.getMessage(), exception);
    }
}
