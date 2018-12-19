package com.metalsa.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingUtil {
	
	private final Log log = LogFactory.getLog(this.getClass());

	@Around("execution(* com.metalsa.controller..*.*(..)) || execution(* com.metalsa.service..*.*(..))"
			+ " || execution(* com.metalsa.repository..*.*(..))")
	public Object logMethods(ProceedingJoinPoint joinPoint) throws Throwable {
			log.info(String.format("Entering class %s method %s",joinPoint.getTarget().getClass().getName(),joinPoint.getSignature().getName()));
			Object retVal = joinPoint.proceed();
			log.info(String.format("Exiting class %s method %s",joinPoint.getTarget().getClass().getName(),joinPoint.getSignature().getName()));
			return retVal;
	}

}
