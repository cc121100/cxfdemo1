package com.cc.cxfdemo.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CxfAop {
	
	@Pointcut("execution(* com.cc.cxfdemo.endpoint.impl..*.*(..))") 
	private void anyMethod() {}//声明一个切入点	
	
	@Before("anyMethod()")
	public void doBefore(){
		System.out.println("--------doBefore---------");
	}
	
	@After("anyMethod()")
	public void doAfter(){
		System.out.println("--------doAfter---------");
	}
	
	@AfterReturning(pointcut="anyMethod()",returning="result")
	public void doAfterReturing(JoinPoint jp, Object result){
		System.out.println("--------doAfterReturing---------");
		System.out.println("Method returned value is : " + result);

	}
	
	@AfterThrowing(pointcut="anyMethod()", throwing="ex")
	public void doAfterThrowing(JoinPoint jp, Exception ex){
		
		System.out.println("--------doAfterThrowing---------");
		System.out.println(jp.getSignature().getName() + " throws ex:" + ex.getMessage()); 
	}
	
	@Around("anyMethod()")
	public Object doAround(ProceedingJoinPoint pj){
		
		System.out.println("--------doAround1---------");
		Object retVal = null;
		try {
			System.out.println("args: " + Arrays.toString(pj.getArgs()));

			retVal = pj.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------doAround2---------");
		return retVal;
	}

}
