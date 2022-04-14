package com.jiajia.jingsai;

import java.util.Arrays;

public class Solution253 {

    public static void main(String[] args) {
        // one
        System.out.println(isPrefixString("iloveleetcode", new String[] {"i","love","leetcode","apples"}));

        System.out.println(minStoneSum(new int[] {4122,9928,3477,9942}, 6));

    }

    /**
     * 5838. 检查字符串是否为数组前缀
     */
    public static boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            if (s.equals(sb.toString())) {
                return true;
            }
            if (s.startsWith(sb.toString())) {
                continue;
            }
            return false;
        }
        return false;
    }

    /**
     * 5839. 移除石子使总数最小
     */
    public static int minStoneSum(int[] piles, int k) {
        int opIndex = piles.length - 1;
        Arrays.sort(piles);
        for (int i = 0; i < k; i++) {
            piles[opIndex] = piles[opIndex] % 2 == 0 ? piles[opIndex] / 2 : piles[opIndex] / 2 + 1;

            if (i == k - 1) {
                break;
            }
            int length = piles.length;
            int t = piles[length - 1];
            int j;
            for (j = length - 2; j >= 0; j--) {
                if (piles[j] > t) {
                    piles[j + 1] = piles[j];
                } else {
                    break;
                }
            }
            piles[j + 1] = t;
        }

        int count= 0;
        for (int pile : piles) {
            count += pile;
        }
        return count;
    }
}
