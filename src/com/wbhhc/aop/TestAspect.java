package com.wbhhc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class TestAspect{   
	
	public void doBefore(JoinPoint jp){  
		System.out.println("log begining methed:"); 
		System.out.println(jp.getTarget().getClass().getName()+".");
		System.out.println(jp.getSignature().getName());	
	}   
	
    public void doThrowing(JoinPoint jp, Throwable ex) {   
        System.out.println("method " + jp.getTarget().getClass().getName()   
                + "." + jp.getSignature().getName() + " throw exception");   
        System.out.println(ex.getMessage());   
    }   
    
    public void doAfter(JoinPoint jp) {   
        System.out.println("log Ending method: "  
                + jp.getTarget().getClass().getName() + "."  
                + jp.getSignature().getName());   
    }   
  
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {   
        long time = System.currentTimeMillis();   
        Object retVal = pjp.proceed();   
        time = System.currentTimeMillis() - time;   
        System.out.println("process time: " + time + " ms");   
        return retVal;   
    }   
}   
