package com.jiajia.daily;

/**
 * Created by Numen_fan on 2022/6/25
 * Desc: 剑指 Offer II 091. 粉刷房子
 */
public class Solution20220625 {

    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
    }

    public static int minCost(int[][] costs) {

        // dp[i][j] i表示第几个房子，j取值0-2，三种颜色，分别表示第i个房子涂成这个颜色的总花费

        // 递推规则
        // dp[i][0]由两个方面而来，dp[i - 1][1] 和dp[i - 1][2];
        // dp[i][1]由两个方面而来，dp[i - 1][0] 和dp[i - 1][2];
        // dp[i][2]由两个方面而来，dp[i - 1][0] 和dp[i - 1][1];

        // 初始化
        // dp[0][0] = cost[0][0];
        // dp[0][1] = cost[0][1];
        // dp[0][2] = cost[0][2];

        int len = costs.length;

        int[][] dp =  new int[len][3];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(dp[len - 1][0], Math.min(dp[len - 1][1], dp[len - 1][2]));

    }
}
