package com.mcrwayfun.exercise._08;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/3
 */
public class RecursiveClassPrint {

    static void printClasses(Class<?> c) {
        if (c == null)
            return;

        System.out.println(c.getName());
        for (Class<?> k : c.getInterfaces()) {
            System.out.println("Interface:" + k.getName());
            printClasses(c.getSuperclass());
        }
        printClasses(c.getSuperclass());
    }

    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("com.mcrwayfun.FancyToy");
        printClasses(aClass);
    }
}
/*
com.mcrwayfun.FancyToy
Interface:com.mcrwayfun.HasBatteries
com.mcrwayfun.Toy
java.lang.Object
Interface:com.mcrwayfun.Waterproof
com.mcrwayfun.Toy
java.lang.Object
Interface:com.mcrwayfun.Shoots
com.mcrwayfun.Toy
java.lang.Object
com.mcrwayfun.Toy
java.lang.Object
 */