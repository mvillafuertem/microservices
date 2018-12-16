package com.mvillafuertem.usermanagementservice.api.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class RestAspect {

    @Around("execution(* com.mvillafuertem.usermanagementservice.api.controller.UserController.*(..))")
    public Object restAspectLog(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        final Object proceed = proceedingJoinPoint.proceed();

        log.info("{}", proceedingJoinPoint.getThis());
        log.info("{}", proceedingJoinPoint.getArgs());
        log.info("{}", proceedingJoinPoint.getKind());
        log.info("{}", proceedingJoinPoint.getSignature());
        log.info("{}", proceedingJoinPoint.getSourceLocation());
        log.info("{}", proceedingJoinPoint.getStaticPart());
        log.info("{}", proceedingJoinPoint.getTarget());

        return proceed;
    }
}
