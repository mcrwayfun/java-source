package com.mcrwayfun.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/20
 */
@Aspect
public class EmployeeAspect {

    /**
     * 所有getName方法执行前会执行该advice
     */
    @Before("execution(public String getName())")
    public void getNameAdvice(){
        System.out.println("Executing Advice on getName()");
    }

    /**
     * com.mcrwayfun.service.impl包路径下的所有类的无参get方法会执行该advice
     */
    @Before("execution(* com.mcrwayfun.service.impl.*.get*())")
    public void getAllAdvice(){
        System.out.println("Service method getter called");
    }
}
