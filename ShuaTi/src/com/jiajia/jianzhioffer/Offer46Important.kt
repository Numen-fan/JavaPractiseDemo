package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 【自己做出来的，感觉好开心啊】
 */
class Offer46Important {

    fun translateNum(num: Int): Int {
        val chs = num.toString()
        if (chs.length < 2) {
            return chs.length
        }
        // length >= 2
        val dp = IntArray(chs.length)
        dp[0] = 1
        dp[1] = dp[0] + if (isValid(chs.substring(0, 2))) 1 else 0
        for (i in 2 until dp.size) {
            dp[i] = dp[i - 1] + if (isValid(chs.substring(i - 1, i + 1))) dp[i - 2] else 0
        }
        return dp[chs.length - 1]
    }

    private fun isValid(str: String): Boolean {
        return str[0] != '0' && str.toInt() < 26
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer46Important()
            println(o.translateNum(12258))
        }
    }
}