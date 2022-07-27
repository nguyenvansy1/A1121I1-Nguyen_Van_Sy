package com.example.book.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Aspect
@Component
public class LoggerBook {
    private Logger logger = Logger.getLogger(LoggerBook.class.getName());
    @AfterReturning("execution(* com.example.book.service.BookService.*(..))")
    public void getLogAfterRunning(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("After returning: Phương thức được gọi là "+ className + methodName);
    }
}
