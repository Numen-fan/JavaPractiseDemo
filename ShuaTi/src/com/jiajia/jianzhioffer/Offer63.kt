package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 63. 股票的最大利润
 */
class Offer63 {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }
        val dp = Array(prices.size) { IntArray(2) } // 注意这是Kotlin的二维数组声明
        // dp[i][0] 表示第i天持有股票的手中现金
        // dp[i][1] 表示第i天不持有股票的手中现金
        dp[0][0] = -prices[0]
        dp[0][1] = 0
        for (i in 1 until prices.size) {
            dp[i][0] = dp[i - 1][0].coerceAtLeast(-prices[i])
            dp[i][1] = dp[i - 1][1].coerceAtLeast(prices[i] + dp[i - 1][0])
        }
        return dp[prices.size - 1][1]; // 不持有股票的现金一点比持有的现金多
    }

    /**
     * 贪心
     */
    fun mehod1(prices: IntArray): Int {
        var max = Int.MIN_VALUE
        var ans = 0
        for (i in prices.indices.reversed()) {
            val price = prices[i]
            if (price < max) {
                ans = ans.coerceAtLeast(max - price)
            } else if (price > max) {
                max = price
            }
        }
        return ans
    }
}