package com.example.demo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Before("execution(public void com.example.demo.DAO.*.add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> Executing @Before advice on add*() in DAO package");
	}
	
	@Before("execution(public * com.example.demo.DAO.*.add*(..))")
	public void beforeAddAccountAdviceWithWildCardAndReturnType() {
		System.out.println("\n====>>> Executing @Before advice on add*() with any return type in DAO package");
	}
	
	@Before("execution(* com.example.demo.DAO.*.*())")
	public void beforeAddAccountAdviceWithWildCardAndPackage() {
		System.out.println("\n====>>> Executing @Before advice on any method in the DAO package");
	}
	
	@Before("execution(* com.example.demo.DAO.*.add*(..))")
	public void beforeAddAccountAdviceWithWildCardAndPackageAndParameters() {
		System.out.println("\n====>>> Executing @Before advice on any add*() in the DAO package with any parameters");
	}
	
	@Before("execution(* com.example.demo.DAO.*.add*(com.example.demo.Account))")
	public void beforeAddAccountAdviceWithWildCardAndPackageAndParametersWithAccount() {
		System.out.println("\n====>>> Executing @Before advice on any add*() in the DAO package with an Account parameter");
	}
	@Before("execution(* com.example.demo.DAO.*.add*(com.example.demo.Account, ..))")
	public void beforeAddAccountAdviceWithWildCardAndPackageAndParametersWithAccountAndOther() {
		System.out.println("\n====>>> Executing @Before advice on any add*() in the DAO package with an Account parameter and any other parameters");
	}
	
	
	

}
