package com.jiajia.jingsai;

import java.util.PriorityQueue;

/**
 * Created by Numen_fan on 2023/1/8
 * Desc:
 */
public class Solution327 {

    public static void main(String[] args) {
        System.out.println(isItPossible("aa", "bcd"));
    }

    /**
     * 6283. 正整数和负整数的最大计数
     * @param nums
     * @return
     */
    public int maximumCount(int[] nums) {
        int p = 0, n = 0;
        for (int a : nums) {
            if (a > 0) {
                p++;
            } else if (a < 0) {
                n++;
            }
        }
        return Math.max(p, n);
    }

    /**
     * 6285. 执行 K 次操作后的最大分数
     * @param nums
     * @param k
     * @return
     */
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a); // 优先级队列，逆序的
        for (int a : nums) {
            queue.add(a);
        }

        long ans = 0;

        for (int i = 0; i < k; i++) {
            int a = queue.poll(); // 取第一个，也就是队列中最大的那个元素
            ans += a;
            queue.add((int) Math.ceil(a / 3d));
        }

        return ans;
    }

    /**
     * 6284. 使字符串总不同字符的数目相等
     * @param word1
     * @param word2
     * @return
     */
    public static boolean isItPossible(String word1, String word2) {
        int[] w1 = new int[26];
        int[] w2 = new int[26];
        for (char c : word1.toCharArray()) {
            w1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            w2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (w1[i] > 0) {
                for (int j = 0; j < 26; j++) {
                    if (w2[j] > 0) {
                        w1[i]--;
                        w2[i]++;
                        w1[j]++;
                        w2[j]--;
                        if (isMatch(w1, w2)) {
                            return true;
                        }
                        w1[i]++;
                        w2[i]--;
                        w1[j]--;
                        w2[j]++;
                    }
                }
            }
        }

        return false;

    }

    private static boolean isMatch(int[] w1, int[] w2) {
        int kind1 = 0;
        int kind2 = 0;
        for (int c : w1) {
           kind1 += c > 0 ? 1 : 0;
        }
        for (int c : w2) {
            kind2 += c > 0 ? 1 : 0;
        }
        return kind2 == kind1;
    }

}
