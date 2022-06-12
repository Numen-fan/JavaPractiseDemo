package com.jiajia.common;

/**
 * Desc: 0-1背包问题
 */
public class BagProblem01 {

    public static void main(String[] args) {

        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;

        System.out.println(bagPro01(weight, value, bagWeight));
    }


    /**
     *
     * @param weight 数组，weight[i] 表示第i个物品的重量
     * @param value 数组， value[i] 表示第i个物品的价值
     * @param w 背包的容量（重量）
     * @return 装满背包的最大价值和
     */
    public static int bagPro01(int[] weight, int[] value, int w) {

        // 1定义dp数组，并初始化
        int n = weight.length;
        int[][] dp = new int[n][w + 1]; // 表示从n件物品中选出若干件，使得容量为w的背包的价值和最大【关键点】

        // 初始化第一列，即背包容量为0
        for (int i = 0; i < n; i++) {
            // 对于背包容量为0的情况，啥也放不下，初始化为0，这一步其实可以忽略，数组初始化本身就是0。
            dp[i][0] = 0;
        }

        // 初始化第一行, 即只选第一个物品
        for (int j = 0; j <= w; j++) {
            if (j < weight[0]) { // 背包容量小于第一个物品的重量
                dp[0][j] = 0;
            } else {
                dp[0][j] = value[0];
            }
        }

        // 迭代

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (j < weight[i]) {
                    // 表明只装i都装不下
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        // 打印出来看看dp数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n - 1][w];
    }
}
