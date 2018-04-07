package com.mvillafuertem.usermanagementservice.rest.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class RestAspect {

    @Around(
            "execution(* com.mvillafuertem.usermanagementservice.rest.controller.UserController.createNewUserWithEmail(..)) || " +
            "execution(* com.mvillafuertem.usermanagementservice.rest.controller.UserController.getUser(..))")
    public Object restAspectLog(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        log.info("{}", proceedingJoinPoint.getArgs());
        log.info("{}", proceedingJoinPoint.getKind());
        log.info("{}", proceedingJoinPoint.getSignature());
        log.info("{}", proceedingJoinPoint.getSourceLocation());
        log.info("{}", proceedingJoinPoint.getStaticPart());
        log.info("{}", proceedingJoinPoint.getTarget());
        log.info("{}", proceedingJoinPoint.getThis());


        return proceedingJoinPoint.proceed();

    }
}
