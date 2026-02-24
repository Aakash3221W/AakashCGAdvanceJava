package com.example.demo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.example.demo.DAO.*.*(..))")
	public void forDaoPackageWithAnyArgs() {}
	
	@Pointcut("execution(* com.example.demo.DAO.*.get*())")
	public void forDaoPackageGetters() {}
	
	@Pointcut("execution(* com.example.demo.DAO.*.set*())")
	public void forDaoPackageSetters() {}
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackageWithAnyArgs() && !(forDaoPackageGetters() || forDaoPackageSetters())")
	public void forDaoPackageNoGetterSetter() {}

	
	@Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method");
    }
	
    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }
	
	

}
