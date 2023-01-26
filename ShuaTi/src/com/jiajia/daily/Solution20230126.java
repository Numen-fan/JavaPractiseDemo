package com.jiajia.daily;

/**
 * 1663. 具有给定数值的最小字符串
 * 【递归回溯】自己做出来的，开心
 */
public class Solution20230126 {

    public static void main(String[] args) {
        Solution20230126 s = new Solution20230126();
        System.out.println(s.getSmallestString(5, 73));
    }

    char[] ans;
    public String getSmallestString(int n, int k) {
        ans = new char[n];
        backTracking(n, k);
        return new String(ans);
    }

    private boolean backTracking(int n, int k) {
        if (n == 0 && k == 0) {
            return true;
        }
        if (k > n * 26) {
            System.out.println("超过了，不满足");
            return false;
        }

        // 这一层从a-b
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            ans[ans.length - n] = c;
            // 开始下一个字符
            if (backTracking(n - 1, k - i - 1)) {
                return true;
            }
            // 回溯
            ans[ans.length - n] = ' ';
        }
        return false;
    }
}
