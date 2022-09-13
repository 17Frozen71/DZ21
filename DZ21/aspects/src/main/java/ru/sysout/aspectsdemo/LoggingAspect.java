package ru.sysout.aspectsdemo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @AfterReturning(pointcut = "@annotation(LogMethod)", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature()
                .getName();
        System.out.println( "LOG: Название метода: " + methodName + " Возвращенное значение: " + result.toString());
    }

    @Around("@annotation(WorkTime)")
    public void logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        logger.log(Level.INFO, joinPoint.getSignature() + " выполнен за " + executionTime + "мс");
    }

    public void log (Object EN, Object RU){
        System.out.println(EN + "\n" + RU);
    }
}
