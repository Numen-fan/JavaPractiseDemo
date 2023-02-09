package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 10- II. 青蛙上台阶
 */
class Offer10IIImportant {
    fun numWays(n: Int): Int {
        if (n == 0) {
            return 1
        }
        if (n < 3) {
            return n
        }
        val mod = 1000000007
        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = 1
        dp[2] = 2 // 第二级台阶，两种上法。

        for (i in 3..n) {
            dp[i] = (dp[i - 1] % mod + dp[i - 2] % mod) % mod
        }
        return dp[n]
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer10IIImportant()
            println(o.numWays(7))
        }
    }
}