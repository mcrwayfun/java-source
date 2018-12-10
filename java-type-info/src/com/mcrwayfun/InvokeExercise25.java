package com.mcrwayfun;

import com.mcrwayfun.exercise._25.Eating;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/11
 * @description
 */

class Student {
    private final String name = "mcrwayfun";

    private final int count = 3;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}

public class InvokeExercise25 {

    public static void main(String[] args) {

        try {
            Eating eating = new Eating();
            // can not access any method

            callHiddenMethod(eating, "breakfast");
            callHiddenMethod(eating, "lunch");
            callHiddenMethod(eating, "dinner");

            Student student = new Student();
            Field name = getHiddenField(student, "name");
            System.out.println("before set name:" + name.get(student));
            name.set(student, "test");
            // output test
            System.out.println("using get:" + name.get(student));
            // output Student{name='mcrwayfun', count=3}
            System.out.println("using toString:" + student);

            Field count = getHiddenField(student, "count");
            System.out.println("before set count:" + count.get(student));
            count.set(student, 333);
            // output 333
            System.out.println("using get:" + count.get(student));
            // output Student{name='mcrwayfun', count=3}
            System.out.println("using toString:" + student);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void callHiddenMethod(Object object, String methodName) throws Exception {
        Method method = object.getClass().getDeclaredMethod(methodName);
        method.setAccessible(Boolean.TRUE);
        method.invoke(object);
    }

    public static Field getHiddenField(Object object, String fieldName) throws Exception {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(Boolean.TRUE);
        return field;
    }
}
