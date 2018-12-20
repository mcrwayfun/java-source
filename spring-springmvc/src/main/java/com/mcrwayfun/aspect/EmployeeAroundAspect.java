package com.mcrwayfun.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/20
 */
@Aspect
public class EmployeeAroundAspect {

    @Around("execution(* com.mcrwayfun.entity.Employee.getName())")
    public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("Before invoking getName() method");
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("After invoking getName() method. Return value=" + value);
        return value;
    }
}
