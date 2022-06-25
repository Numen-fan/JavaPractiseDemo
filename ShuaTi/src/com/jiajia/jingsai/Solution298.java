package com.jiajia.jingsai;

import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Numen_fan on 2022/6/19
 * Desc:
 */
public class Solution298 {

    public static void main(String[] args) {

        System.out.println(greatestLetter("lEeTcOdE"));

        System.out.println(minimumNumbers(58, 9));

        System.out.println(Math.pow(2, 0) > 1);

        System.out.println(1 << 1);

        System.out.println(1 << 4);

        System.out.println(longestSubsequence("0001010100110110010111011110001111111000010110000001000100001111000000111" +
                "1100100011110011110100111100101110100101101110100101101100111111101001110001111011101000001000001011100100111110110000111", 300429827));


    }


    /**
     * 5242. 兼具大小写的最好英文字母
     * @param s
     * @return
     */
    public static String greatestLetter(String s) {
        if (s.length() <  2) {
            return "";
        }

        int[] arr = new int[26];
        int[] arr1 = new int[26];

        for (char ch : s.toCharArray()) {
            int loc = ch - 'a';
            int loc1 = ch - 'A';

            if (loc < 26 && loc >= 0) {
                // 小写
                arr[loc] = 1;
            } else if (loc1 < 26 && loc1 >= 0) {
                arr1[loc1] = 1;
            }
        }

        for (int i = 25; i >= 0; i--) {
            if (arr[i] + arr1[i] == 2) {
                return String.valueOf((char) ('A' + i));
            }
        }
        return "";
    }

    /**
     * 5218. 个位数字为 K 的整数之和
     * @param num
     * @param k
     * @return
     */
    public static int minimumNumbers(int num, int k) {

        if (num == 0) {
            return num;
        }

        int lastNum = num % 10;

        if (lastNum % 2 != 0 && k % 2 == 0) {
            return -1;
        }

        // 转为dp问题， dp[j] 表示和为j的最小多重集长度, 由dp[j - num[i]]而来

        int[] dp = new int[num + 1];

        // 初始化
        dp[0] = 0;

        for (int i = 1; i <= num; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // 背包容量是num，物品是 0 - num；
        // 外层循环应该是背包，内层循环应该是物品
        for (int i = 0; i <= num; i++) { // 背包
            for (int j = 0; j <= num; j++) { // 物品
                if (j % 10 == k && i - j >= 0 && dp[i - j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }

        if (dp[num] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[num];
    }


    public static List<Character> path = new ArrayList<>();

    public static int length = Integer.MIN_VALUE;

    /**
     * 6099. 小于等于 K 的最长二进制子序列
     * @param s
     * @param k
     * @return
     */
    public static int longestSubsequence(String s, int k) {

//        int removed = 0;
//        int sum = 0;
//
//        s = new StringBuilder(s).reverse().toString();
//        // 从后向前遍历，0都保留，1 判断
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '1') {
//                if (sum >= k) {
//                    removed++;
//                } else {
//                    // 遇到1，判断保留当前1是否有效
//                    sum += (1 << i);
//                    if (sum > k) {
//                        removed++;
//                    }
//                }
//            }
//        }
//
//        return s.length() - removed;

        int cnt =0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                cnt++;
            }
            else{
                if(k>=(1<<cnt)&&cnt<=30){
                    k-=(1<<cnt);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void method(String s, int k, int startIndex) {
        // 判断path的有效性
        if (!path.isEmpty()) {
            if (isValid(path, k)) {
                length = Math.max(path.size(), length);
            } else {
                return;
            }
        }

        if (startIndex >= s.length()) {
            return;
        }


        for (int i = startIndex; i < s.length(); i++) {
            Character character = s.charAt(i);
            path.add(character);

            if (!isValid(path, k)) {
                return;
            }

            method(s, k, i + 1);
            // 回溯
            path.remove(path.size() - 1);
        }

        return;
    }

    public static boolean isValid(List<Character> path, int k) {
        int num = 0;
        int len = path.size();
        for (int i = 0; i < len; i++) {
            if (path.get(i) == '0') {
                continue;
            }
            num += Math.pow(2, len - i - 1);
            if (num > k) {
                return false;
            }
        }
        return true;
    }

}
