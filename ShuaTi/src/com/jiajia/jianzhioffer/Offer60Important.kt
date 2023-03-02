package com.jiajia.jianzhioffer

import java.util.*

/**
 * 剑指 Offer 60. n个骰子的点数
 */
class Offer60Important {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer60Important()
            println(o.dicesProbability(2).contentToString())
        }
    }

    /**
     * n个骰子，一共有6的n次方种组合
     * 和的范围从 n ~ 6*n, 一共有6n - n + 1 = 5n + 1种情况
     * dp[i][j]可以表示i个骰子掷出和为j的概率
     * 那么对于新增的一个骰子，可以掷出1-6，概率为1/6.
     * 那么就有dp[i][j] = dp[i - 1][j - k] * 1/6的累加，k = 1 ~ 6
     */
    fun dicesProbability(n: Int): DoubleArray {
        val dp = Array(n + 1){ DoubleArray(6 * n + 1)}
        for (i in 1 until 7) { // 注意这里不能用fill去处理
            dp[1][i] = 1 / 6.0
        }
        for (i in 2 .. n) { // i个骰子
            for (j in i..6 * i) { // 掷出的和i ~ 6 * i的情况
                for (k in 1..6) { // 新增的这一枚骰子的点数从1~6
                    if (j - k >= 0) {
                        dp[i][j] += dp[i - 1][j - k] * 1/6.0
                    }
                }

            }
        }

        val ans = DoubleArray(5 * n + 1)
        var index = 0
        for (i in n .. 6 * n) { // n个骰子的和从n ~ 6n
            ans[index++] = dp[n][i]
        }
        return ans
    }

}