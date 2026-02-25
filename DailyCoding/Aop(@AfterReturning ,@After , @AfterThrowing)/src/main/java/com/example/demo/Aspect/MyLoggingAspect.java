package com.example.demo.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.Account;
import java.util.List;



@Aspect
@Component
@Order(2)
public class MyLoggingAspect {
	
	@After("execution(* com.example.demo.DAO.AccountDAO.findAccounts(*))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("\n=====>>> Executing @After (finally) on method: " + methodSignature);
	}
	
	@AfterThrowing(pointcut="execution(* com.example.demo.DAO.AccountDAO.findAccounts(*))",
				 throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("\n=====>>> Executing @AfterThrowing on method: " + methodSignature);
		System.out.println("\n=====>>> The exception is: " + theExc);
	}
	
	@AfterReturning(pointcut="execution(* com.example.demo.DAO.AccountDAO.findAccounts(..))",
				 returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + methodSignature);
		System.out.println("\n=====>>> result is: " + result);
		
		
		//convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n=====>>> result is: " + result);
		
	}

    private void convertAccountNamesToUpperCase(List<Account> result) {
		// loop through accounts
    	for (Account tempAccount : result) {
			String theUpperName = tempAccount.getName().toUpperCase();
			tempAccount.setName(theUpperName);
		}
	}

	@Before("com.example.demo.Aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {

                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }

}
