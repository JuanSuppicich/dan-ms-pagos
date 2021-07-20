package com.durandsuppicich.danmspagos.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.durandsuppicich.danmspagos.service.*.*(..))")
    private void serviceMethods() {}

    @Pointcut("execution(* com.durandsuppicich.danmspagos.repository.*.*(..))")
    private void repositoryMethods() {}

    @Before("serviceMethods() || repositoryMethods()" )
    public void doBefore(JoinPoint joinPoint) {
        logger.debug(joinPoint.getTarget().getClass() + 
            ". METODO A EJECUTAR: " + joinPoint.getSignature().getName() + 
            ". ARGUMENTOS: " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("serviceMethods() || repositoryMethods()")
    public void doAfter(JoinPoint joinPoint) {
        logger.debug(joinPoint.getTarget().getClass() + 
            ". METODO EJECUTADO: " + joinPoint.getSignature().getName() + 
            " .ARGUMENTOS: " + Arrays.toString(joinPoint.getArgs()));
    }
}