package com.eazybytes.eazyschool.aspect;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Slf4j
@Aspect
@Component 
public class LoggerAspect {

	@Around("execution(* com.eazybytes.eazyschool..*.*(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
		log.info(joinPoint.getSignature().toString() + " execution starts");
		Instant now = Instant.now();
		Object returnObj = joinPoint.proceed();
		Instant finishTiming = Instant.now();
		Long timeElapsed = Duration.between(now, finishTiming).toMillis();
		log.info("Time taken to execute: "+joinPoint.getSignature().toString()+" method is : "+ timeElapsed);
		log.info(joinPoint.getSignature().toString() + " execution ends");
		
		return returnObj;
	}
	
	@AfterThrowing(value="execution(* com.eazybytes.eazyschool..*.*(..))", throwing = "ex")
	public void logException(JoinPoint joinPoint, Exception ex) {
		log.error("exception occured at method: "+joinPoint.getSignature() +" "+ex.getMessage());
	}
}
