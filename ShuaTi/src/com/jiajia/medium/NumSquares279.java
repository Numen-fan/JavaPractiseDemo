package com.jiajia.medium;

/**
 * Created by Numen_fan on 2022/6/19
 * Desc: [279] 完全平方数
 */
public class NumSquares279 {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {

        // 完全背包问题
        // dp[j] 表示和为j的最少数量，那么考虑num, dp[j]从dp[j - num]而来

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) { // 背包容量
            for(int j = 1; j <= Math.sqrt(n); j++) { // 物品
                if (i - j * j >= 0 && dp[i - j * j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }

        if (dp[n] == Integer.MAX_VALUE) {
            return 0;
        }

        return dp[n];

    }
}
