package com.jiajia.jianzhioffer

import com.jiajia.kit.ArrayUtils

/**
 * 剑指 Offer 47. 礼物的最大价值
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=b3nqjxj
 */
class Offer47 {
    fun maxValue(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val dp = Array(m) { IntArray(n) }

        for (i in 0 until m) {
            dp[i][0] = grid[i][0] + if (i == 0) 0 else dp[i - 1][0]
        }

        for (j in 0 until n) {
            dp[0][j] = grid[0][j] + if (j ==0) 0 else dp[0][j - 1]
        }
        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[i][j] = dp[i - 1][j].coerceAtLeast(dp[i][j - 1]) + grid[i][j]
            }
        }
        return dp[m - 1][n - 1]
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer47()
            println(o.maxValue(ArrayUtils.string2IntArray2("[[1,3,1],[1,5,1],[4,2,1]]")))
        }
    }
}