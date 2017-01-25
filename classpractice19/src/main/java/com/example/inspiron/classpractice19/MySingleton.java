package com.example.inspiron.classpractice19;

/**
 * Created by INSPIRON on 13-Jan-17.
 */
public class MySingleton {
    private static MySingleton ourInstance = new MySingleton();

    public static MySingleton getInstance() {

        return ourInstance;
    }

    private MySingleton() {
    }
}
