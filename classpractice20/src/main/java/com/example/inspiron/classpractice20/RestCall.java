package com.example.inspiron.classpractice20;

/**
 * Created by INSPIRON on 17-Jan-17.
 */

public class RestCall {

    public static void main(String[] args) {

        int i = 45;

        int result = 1;
        for (int j = i; j > 0; j--) {
            result = result * j;

        }

//        System.out.println(result);
//
//        System.out.println("recursive: " + doFactorial(5));
//
//        System.out.println(findPrime(12));

        System.out.println("Fibonacci "  + doFibonacci(7));




    }

    public static int doFactorial(int i){

        if(i==0) return 1;

        return i * doFactorial(i-1);
    }

    private static int findPrime(int i){
        int k =i +1;
        while(true){
            if(isPrime(i)){
                return k;
        }
                k++;
        }
    }

    private static boolean isPrime(int i){
        for (int j = i-1 ; j > 1 ; j--) {
            if(i%j==0)
                return false;
        }
        return true;
    }

    private static int doFibonacci(int i){
       if(i==0)
           return 0;
        else if(i==1)
            return 1;
        else
           return doFibonacci(i-1) + doFibonacci(i-2);

    }
}
