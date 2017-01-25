package com.example.inspiron.classpractice19;

/**
 * Created by INSPIRON on 13-Jan-17.
 */

public class MySingleton2 {

    private static MySingleton2 myInstance = new MySingleton2();

    private MySingleton2(){}

    public static MySingleton2 getMyInstance(){

        return myInstance;
    }
}
