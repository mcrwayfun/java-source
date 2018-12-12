package com.mcrwayfun;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/12
 * @description
 */
public class InvocationHandlerImpl implements InvocationHandler {

    // 需要代理的真实对象
    private Object subject;

    public InvocationHandlerImpl(Object subject){
        this.subject = subject;
    }

    /**
     * 该方法负责集中处理动态代理类上的所有方法调用
     * 调用处理器根据这三个参数进行预处理或分派到委托类实例上反射执行
     *
     * @param proxy  代理类实例
     * @param method 被调用的方法对象
     * @param args   调用参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("======进入动态代理方法======");
        System.out.println("======被代理对象为:" + subject);
        System.out.println("======执行方法为:" + method);

        // invoke传入的object需要的是代理的真实对象
        Object invoke = method.invoke(subject, args);

        System.out.println("=======调用结束======");
        return invoke;
    }
}
