package com.jiajia.jianzhioffer

class Offer14IIIImportant {

    fun cuttingRope(n: Int): Int {
        // 这道题要考虑大数问题，动态规划并不是最优解
        val mod = (1e9 + 7).toInt()
//        val dp = IntArray(n + 1)
//        for (i in 2..n) {
//            for (j in 1 until i) {
//                dp[i] = dp[i].coerceAtLeast(((i-j)*j).coerceAtLeast(dp[i - j] * j))
//            }
//        }
//        return dp[n] % mod

        // 有证明是尽可能的拆分成多个3，进行乘法，这样得到的结果是最大的，这一点就死记硬背吧，唉
        var tempN = n
        if (n == 2) {
            return 1
        }

        if (n == 3) {
            return 2
        }

        if (n == 4) {
            return 4
        }


        var res = 1L
        while (tempN > 4) {
            res *= 3
            res %= mod
            tempN -= 3
        }

        return (tempN * res % mod).toInt()
    }

}