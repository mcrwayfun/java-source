package com.mcrwayfun.aspect;

import com.mcrwayfun.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description 测试aop方法
 * @date Created in 2018/12/20
 */
public class SpringAopMain {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop-test.xml");
        EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);

        System.out.println(employeeService.getEmployee().getName());

        employeeService.getEmployee().setName("Pankaj");

        employeeService.getEmployee().throwException();

        ctx.close();
    }
}
