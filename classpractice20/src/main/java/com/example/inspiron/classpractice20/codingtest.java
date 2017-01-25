package com.example.inspiron.classpractice20;

import java.util.HashMap;

/**
 * Created by INSPIRON on 18-Jan-17.
 */

public class codingtest {

    public static void main(String... args){
        System.out.println(checkPattern("abba", "dog cat cat dog"));
        System.out.println(checkPattern("abba", "dog cat cat fish"));
        System.out.println(checkPattern("aaaa", "dog cat cat dog"));
        System.out.println(checkPattern("abba", "dog dog dog dog"));
    }

    public static boolean checkPattern(String pattern, String str){
        char[] charArray = pattern.toCharArray();
        String[] strSplit = str.split(" ");

        HashMap<String, Character> hashMap = new HashMap<>();
        int i = 0;

        for (String s : strSplit) {
            if (!hashMap.containsKey(s)) {
                if (hashMap.containsValue(charArray[i])) {
                    return false;
                }
                hashMap.put(s, charArray[i]);
            } else {
                char ch = hashMap.get(s);
                if (ch != charArray[i]) {
                    return false;
                }
            }
            i++;
        }

        return true;
    }
}
