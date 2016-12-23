package com.example.inspiron.homework6;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by INSPIRON on 22-Dec-16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    public User(){}

    private String name;
    private String password;
    private int age;
    private double grade;

    public User(String name, String password, int age, double grade) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.grade = grade;
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
