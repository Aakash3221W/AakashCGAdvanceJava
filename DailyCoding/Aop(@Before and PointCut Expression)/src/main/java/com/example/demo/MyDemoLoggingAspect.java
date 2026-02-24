package com.example.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> Executing @Before advice on addAccount()");
	}
	
	
	@Before("execution(public void addAccount(com.example.demo.Account))")
	public void beforeAddAccountWithParamAdvice() {
		System.out.println("\n====>>> Executing @Before advice on addAccount(Account)");
	}
	
	@Before("execution(public void add*(..))")
	public void beforeAddAccountAdviceWithWildCard() {
		System.out.println("\n====>>> Executing @Before advice on add*(..)");
	}
	
	@Before("execution(public * add*(..))")
	public void beforeAddAccountAdviceWithWildCardAndReturnType() {
		System.out.println("\n====>>> Executing @Before advice on add*(..) with any return type");
	}
	
	@Before("execution(* com.example.demo.*.*(..))")
	public void beforeAddAccountAdviceWithWildCardAndPackage() {
		System.out.println("\n====>>> Executing @Before advice on any method in the package");
	}
	
	
	
}
