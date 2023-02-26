package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 14- I. 剪绳子
 */
class Offer14IImportant {

    fun cuttingRope(n: Int): Int {
        // 动态规划，核心是将一个数i，拆分第一个数j，那么剩余i-j有两种情况
        // 1 i -j 不再继续拆解，此时的值为 j * (i - j)
        // 2 i - j 继续拆解为另外两个整数的和，此时的值为 j * dp[i - j]
        // 最后取最大值
        val dp = IntArray(n + 1)
        for (i in 2..n) {
            for (j in 0 until i) {
                dp[i] = dp[i].coerceAtLeast(((j * (i - j)).coerceAtLeast(j * dp[i - j])))
            }
        }
        return dp[n]
    }
}