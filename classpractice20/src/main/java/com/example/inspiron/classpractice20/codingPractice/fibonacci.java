package com.example.inspiron.classpractice20.codingPractice;

/**
 * Created by INSPIRON on 18-Jan-17.
 */

public class fibonacci {

    public static void main(String[] args) {

        printFibonacci(5);

    }

    private static void printFibonacci(int length){
        int n1 = 1;
        int n2 = 1;
        int n3 = 0;
        System.out.println(n1);
        System.out.println(n2);
        for (int i = 1; i <=length ; i++) {
            n3 = n2 + n1;
            n1=n2;
            n2=n3;
            System.out.println(n3);
        }
        
    }

}
