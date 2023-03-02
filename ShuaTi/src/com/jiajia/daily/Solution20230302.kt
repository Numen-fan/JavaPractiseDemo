package com.jiajia.daily

import java.lang.StringBuilder

/**
 * 面试题 05.02. 二进制数转字符串
 */
class Solution20230302 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230302()
            println(s.printBin(0.625))
        }
    }

    /**
     * 【关键】因此在二进制表示中，将一个数乘以 222 的效果是将小数点向右移动一位。
     * 0.625 * 2 = 1.25 去掉整数部分就是0.25
     * 0.25 * 2 = 0.5 去掉整数部分还是0.5
     * 0.5 * 2 = 1.0 去掉整数部分就是0
     * 三个整数部分分别是101
     */
    fun printBin(num: Double): String {
        val sb = StringBuilder("0.") // 先将整数部分0.添加进去
        var n = num
        while (n > 0 && sb.length < 32) {
            n *= 2
            val digit = n.toInt() // 取整数位置
            sb.append(digit)
            n -= digit // 减去整数位置
        }
        return if(sb.length <= 32) sb.toString() else "ERROR"

    }

}