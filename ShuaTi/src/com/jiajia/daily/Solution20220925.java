package com.jiajia.daily;

/**
 * Created by Numen_fan on 2022/9/25
 * Desc: 788. 旋转数字
 */
public class Solution20220925 {

    public static void main(String[] args) {

        System.out.println(rotatedDigits(10));

    }

    public static int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            if (str.contains("3") || str.contains("4") || str.contains("7")) {
                // 包含这些字符的数字都不是有效的
                continue;
            }

            if (satisfy(i)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 判断num是否有效
     */
    private static boolean satisfy(int num) {
        // 不包含3 4 7
        char[] chs = String.valueOf(num).toCharArray();
        for (int i = 0; i < chs.length; i++) {
            chs[i] = getReverseChar(chs[i]);
        }
        return Integer.parseInt(String.valueOf(chs)) != num;
    }

    private static char getReverseChar(char c) {
        switch (c) {
            case '0':
            case '1':
            case '8':
                return c;
            case '2':
                return '5';
            case '5':
                return '2';
            case '6':
                return '9';
            case '9':
                return '6';
        }
        return c;
    }


}
