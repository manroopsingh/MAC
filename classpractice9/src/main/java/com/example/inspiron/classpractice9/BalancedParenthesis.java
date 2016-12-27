package com.example.inspiron.classpractice9;

import java.util.Stack;

/**
 * Created by INSPIRON on 23-Dec-16.
 */

public class BalancedParenthesis {


    public static void main(String[] args) {

        String str = "{[()]}";

        checkBalanced(str);

    }

    public static boolean checkBalanced(String str) {

        Stack<Character> S = new Stack<Character>();
        for(int a = 0; a < str.length(); a++)
        {
            char let = str.charAt(a);
            if(let == '[' || let == '{' || let == '(')
                S.push(let);
            else if(let == ']' || let == '}' || let == ')')
            {
                if(S.empty())
                    return false;
                switch(let)
                {
                    case ']':
                        if (S.pop() != '[')
                            return false;
                        break;
                    case '}':
                        if (S.pop() != '{')
                            return false;
                        break;
                    case ')':
                        if (S.pop() != '(')
                            return false;
                        break;
                    default:
                        break;
                }
            }
        }
        if(S.empty())
            return true;
        return false;
    }
}
