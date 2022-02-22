package com.jiajia.easy;

import java.util.Stack;

/**
 * app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */
public class SignVaild20 {

    public static void main(String[] args) {
        System.out.println(isValid("{{[{}]}}"));
    }

    public static boolean isValid(String s) {
        if(s.length() % 2 != 0)  { // 如果串s的长度为奇数，则必定是无效的。
            return false;
        }

        // method 1
         return method1(s);

        // method 2
//        return method2(s);
    }
    /**
     method 2
     比较耗时
     */
    private static boolean method2(String s) {
        while(s.contains("{}") || s.contains("[]") || s.contains("()")) {
            s = s.replace("{}","").replace("[]", "").replace("()", "");
        }
        return s.length() == 0;
    }

    /**
     method 1
     */
    private static boolean method1(String s) {
        if(s.length() % 2 != 0)  { // 如果串s的长度为奇数，则必定是无效的。
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for(int index = 0; index < s.length(); index++) {
            char curChar = s.charAt(index);
            if(isLeftSign(curChar)) {
                // 入栈
                stack.push(curChar);
            } else {
                // 出栈匹配
                if(stack.empty()) {
                    return false;
                }

                char ch = stack.pop();
                if(!isTwoSignMatch(ch, curChar)) {
                    return false;
                }
            }
        }

        return stack.empty();

    }

    public static boolean isLeftSign(char ch) {
        return ch == '{' || ch == '[' || ch == '(';
    }

    private static boolean isTwoSignMatch(char ch1, char ch2) {
        if(ch1 == '{') {
            return ch2 == '}';
        }
        if(ch1 == '[') {
            return ch2 == ']';
        }
        if(ch1 == '(') {
            return ch2 == ')';
        }
        return false;
    }
}
