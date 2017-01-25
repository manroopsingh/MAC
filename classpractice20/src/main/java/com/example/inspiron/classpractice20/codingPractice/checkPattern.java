package com.example.inspiron.classpractice20.codingPractice;

import java.util.HashMap;

/**
 * Created by INSPIRON on 18-Jan-17.
 */

public class checkPattern {

    public static void main(String[] args) {

        System.out.println(checkpattern("aaba", "hello hello hola hello"));
        System.out.println(checkpattern("helo", "he eeo ll oo"));

    }


    public static boolean checkpattern(String pattern, String string) {
        char[] chars = pattern.toCharArray();
        String[] strings = string.split(" ");

        HashMap<String, Character> hashMap = new HashMap<>();

        int i = 0;
        for (String s : strings) {
            if (!hashMap.containsKey(strings[i])) {
                if(hashMap.containsValue(chars[i]))
                    return false;
                hashMap.put(s, chars[i]);
            }
            else
            {
                char ch = hashMap.get(s);
                if (ch !=chars[i]){
                    return false;
                }
            }
            i++;
        }
        return true;
    }

}
