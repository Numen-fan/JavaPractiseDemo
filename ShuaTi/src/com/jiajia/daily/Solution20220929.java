package com.jiajia.daily;

/**
 * Created by Numen_fan on 2022/10/1
 * Desc:
 */
public class Solution20220929 {

    public static void main(String[] args) {
        System.out.println(isFlipedString("waterbottle", "erbottlewat"));
    }

    public static boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        // 测试case ""
        if (s1.length() == 0) {
            return true;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(0) == s2.charAt(i)) {
                String str = s2.substring(i) + s2.substring(0, i);
                if (str.equals(s1)) {
                    return true;
                }
            }
        }

        return false;

    }

}
