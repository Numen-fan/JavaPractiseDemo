package com.jiajia.easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsPalindrome125 {

    public static void main(String[] args) {
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        if(s.trim().length() == 0) { // 空字符串
            return true;
        }
        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch != '{' &&isCharDigitOrLetter(ch)) {
                sb.append(ch);
            }
        }

        String str = sb.toString();
        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;

    }

    public static boolean isPalindrome2(String s) {
        if(s.trim().length() == 0) { // 空字符串
            return true;
        }

        Pattern pattern = Pattern.compile("[^0-9a-zA-Z]");
        Matcher matcher = pattern.matcher(s);
        s = matcher.replaceAll("");

        s = s.toLowerCase();

        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;

    }

    private static boolean isCharDigitOrLetter(char ch) {
        return ch - '0' >= 0 && ch - '0' <= 9 || ch - 'a' >= 0 && ch - 'a' <= 26;
    }
}
