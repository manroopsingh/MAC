package com.example.inspiron.classpractice8;

/**
 * Created by INSPIRON on 22-Dec-16.
 */

public class User {


    private String name, password;
    private double grade;
    private int age;

    public User(String name, String password, double grade, int age) {
        this.name = name;
        this.password = password;
        this.grade = grade;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }



}
