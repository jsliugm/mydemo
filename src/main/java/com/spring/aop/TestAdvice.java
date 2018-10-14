package com.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class TestAdvice implements MethodBeforeAdvice, AfterReturningAdvice,
		ThrowsAdvice {
	public void afterReturning(Object arg0, Method method, Object[] arg2,
			Object target) throws Throwable {
	
	}

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		
	}
	
}
