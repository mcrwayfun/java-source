package com.mcrwayfun.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/20
 */
@Aspect
public class EmployeeAnnotationAspect {

    @Before("@annotation(com.mcrwayfun.aspect.Loggable)")
    public void myAdvice() {
        System.out.println("Executing myAdvice!!");
    }

}
