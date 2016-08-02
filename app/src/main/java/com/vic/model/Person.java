package com.vic.model;

/**
 * Created by Vic on 2016/8/1 0001.
 */
public class Person {
    private String name = "";
    private int age = 0;
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
