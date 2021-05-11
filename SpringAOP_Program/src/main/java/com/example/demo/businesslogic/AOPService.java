package com.example.demo.businesslogic;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPService {

	@Pointcut("execution(public void com.example.demo.businesslogic.BusinessLogic.saveEmployee())")
	
	public void p1() {
		
	}
	
	@Before("p1()")
	public void tx() {
		System.out.println("Begin Tx");
	}
	
	@After("p1()")
	public void commit() {
		System.out.println("TX Commited");
	}
	
	@AfterReturning("p1()") 
	public void commitAr() {
		System.out.println("After Returning Demo");
	}
	
	@AfterThrowing(value = "p1()" , throwing ="th")
	public void commitAt() {
		System.out.println("Ater Throwing Demo");
	}
	
	@Around("p1()")
	public void aroundDemo(ProceedingJoinPoint jp) {
		System.out.println("Before Business method");
		try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("After Business method");
	}
}
