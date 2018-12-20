package com.mcrwayfun.entity;

import com.mcrwayfun.aspect.Loggable;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/20
 */
public class Employee {

    private String name;

    public String getName() {
        return name;
    }

    // custom java annotation
    @Loggable
    public void setName(String name) {
        this.name = name;
    }

    public void throwException() {
        throw new RuntimeException("Dummy Exception");
    }
}
