package com.mcrwayfun.entity;

import java.io.Serializable;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/23
 * @description
 */
public class User implements Serializable {

    private Long id;
    private String name;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
