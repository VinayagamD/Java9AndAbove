package com.vinaylogics.springboot.springaop.aops;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Consumer;

@Component
@Aspect
@Slf4j
public class LoggingAspects {

    @Pointcut("execution(* com.vinaylogics.springboot.springaop.controllers.*.*(..))")
    private void forControllerPackages(){
    }

    @Pointcut("execution(* com.vinaylogics.springboot.springaop.services.*.*(..))")
    private void forServicesPackages(){
    }

    @Pointcut("execution(* com.vinaylogics.springboot.springaop.repositories.*.*(..))")
    private void forRepositoryPackages(){
    }

    @Pointcut("forControllerPackages() || forServicesPackages() || forRepositoryPackages()")
    private void forApplicationFlow(){}

    @Before("forApplicationFlow()")
    public void beforeControllerMethodCall(JoinPoint joinPoint){
        //		 display the method calling
        String method = joinPoint.getSignature().toShortString();
        log.info("=========>>> in @Before: calling method: " + method);

//		display the arguments to the method

//		get the arguments
        Object[] args = joinPoint.getArgs();

//		loop through and display the arguments
        Consumer<Object> argConsumer = (arg) -> log.info("==========>  argument: " + arg);

        Arrays.asList(args).forEach(argConsumer);
    }

    @AfterReturning(pointcut = "forApplicationFlow()",
            returning= "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
//		display method we are returning from
        String method = joinPoint.getSignature().toShortString();
        log.info("=========>>> in @AfterReturning: from method: " + method);

//		display the data returned
        log.info("=========>>> result: " + result);
    }


    @AfterThrowing(pointcut = "forApplicationFlow()", throwing = "error")
    public void afterThrowingException(JoinPoint jp, Throwable error){
        log.info("Method Signature: "  + jp.getSignature());
        log.info("Exception: "+error);
    }

    @Around("forApplicationFlow()")
    public Object beforeAfterExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("Around advice");
        Object[] args = proceedingJoinPoint.getArgs();
        if(args.length>0){
            log.info("Arguments passed: " );
            for (int i = 0; i < args.length; i++) {
                log.info("arg "+(i+1)+": "+args[i]);
            }
        }

        Object result = proceedingJoinPoint.proceed(args);
        log.info("Returning " + result);
        return result;
    }
}
