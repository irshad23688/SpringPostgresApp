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
			long startTime = System.nanoTime();
			Object retVal = joinPoint.proceed();
			long endTime = System.nanoTime();
			long totatTime = endTime - startTime;
			log.info(String.format("Exiting class %s method %s total time elapsed %s ms",joinPoint.getTarget().getClass().getName(),joinPoint.getSignature().getName(),totatTime/1000000));
			return retVal;
	}

}
