package com.jiajia.daily;

import java.util.Arrays;

public class Solution20220803 {

    public static void main(String[] args) {
        System.out.println(orderlyQueue("gxzv", 4));
    }

    public static String orderlyQueue(String s, int k) {

        // k大于1，可以任意交换两个元素的位置，因此可以完美实现一个排序
        if(k > 1) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            return String.copyValueOf(chs);
        }

        int len = s.length();

        int moveCnt = len; // 移动moveCnt

        String ans = s;

        String newStr = s;

        while(moveCnt > 0) {
            moveCnt--;
            char[] chs = newStr.toCharArray();
            char maxCharInK = chs[0];
            int maxCharIndex = 0;
            for (int i = 1; i < k; i++) {
                if (chs[i] > maxCharInK) {
                    maxCharInK = chs[i];
                    maxCharIndex = i;
                }
            }

            // 将maxCharIndex处的字符移动到最后
            for(int i = maxCharIndex; i < len - 1; i++) {
                chs[i] = chs[i + 1];
            }

            chs[len - 1] = maxCharInK;
            String tempStr = String.copyValueOf(chs);
            ans = ans.compareTo(tempStr) < 0 ? ans : tempStr;
            newStr = tempStr;
        }

        return ans;
    }

}
