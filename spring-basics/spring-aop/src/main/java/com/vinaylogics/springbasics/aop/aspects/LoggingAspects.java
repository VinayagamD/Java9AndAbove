package com.vinaylogics.springbasics.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Consumer;

@Aspect
@Component
public class LoggingAspects {
    Logger logger = LoggerFactory.getLogger(LoggingAspects.class);

    @Pointcut("execution(* com.vinaylogics.springbasics.aop.controllers.*.*(..))")
    private void forControllerPackage(){

    }


    //	do the same for the services
    @Pointcut("execution(* com.vinaylogics.springbasics.aop.services.*.*(..))")
    private void forServicePackage() {

    }


    @Pointcut("execution(* com.vinaylogics.springbasics.aop.repositories.*.*(..))")
    private void forDAOPackage() {

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow() {

    }

    @Before("forAppFlow()")
    public void beforeControllerMethodCall(JoinPoint joinPoint){
        //		 display the method calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("=========>>> in @Before: calling method: " + method);

//		display the arguments to the method

//		get the arguments
        Object[] args = joinPoint.getArgs();

//		loop through and display the arguments
        Consumer<Object> argConsumer = (arg) -> logger.info("==========>  argument: " + arg);

        Arrays.asList(args).forEach(argConsumer);
    }

    //	add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()",
            returning= "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
//		display method we are returning from
        String method = joinPoint.getSignature().toShortString();
        logger.info("=========>>> in @AfterReturning: from method: " + method);

//		display the data returned
        logger.info("=========>>> result: " + result);

    }

    @AfterThrowing(pointcut = "forAppFlow()", throwing = "error")
    public void afterThrowingException(JoinPoint jp, Throwable error){
        System.out.println("Method Signature: "  + jp.getSignature());
        System.out.println("Exception: "+error);
    }

    @Around("forAppFlow()")
    public Object beforeAfterExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around advice");
        Object[] args = proceedingJoinPoint.getArgs();
        if(args.length>0){
            System.out.print("Arguments passed: " );
            for (int i = 0; i < args.length; i++) {
                System.out.print("arg "+(i+1)+": "+args[i]);
            }
        }

        Object result = proceedingJoinPoint.proceed(args);
        System.out.println("Returning " + result);
        return result;
    }

}
