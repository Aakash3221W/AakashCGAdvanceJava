package com.example.demo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class AopExpressions {
	
	@Pointcut("execution(* com.example.demo.DAO.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.example.demo.DAO.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.example.demo.DAO.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}

}
