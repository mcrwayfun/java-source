package com.mcrwayfun;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/12
 * @description 动态代理演示
 */
public class DynamicProxyDemonstration {

    public static void main(String[] args) {

        // 代理的真实对象
        Subject realSubject = new RealObject();

        /**
         * InvocationHandlerImpl 实现了 InvocationHandler 接口，
         * 并能实现方法调用从代理类到委托类的分派转发
         * 其内部通常包含指向委托类实例的引用，用于真正执行分派转发过来的方法调用.
         * 即：要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法
         */
        InvocationHandler handler = new InvocationHandlerImpl(realSubject);

        // 类加载器
        ClassLoader classLoader = realSubject.getClass().getClassLoader();
        // 类接口数组
        Class<?>[] interfaces = realSubject.getClass().getInterfaces();

        // 获取动态代理实例
        Subject subject = (Subject)Proxy.newProxyInstance(classLoader, interfaces, handler);
        // 调用方法
        subject.sayHello();
    }

}
