package com.jiajia.jianzhioffer

/**
 * 面试题67. 把字符串转换成整数
 */
class Offer67Important {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer67Important()
            println(o.strToInt( "+1"))
        }
    }

    fun strToInt(str: String): Int {
        var ans = 0
        val s = str.trim() // 去掉首尾的空格
        if (s.isEmpty()) {
            return 0
        }
        var sign = if (s[0] == '-') -1 else 1 // 符号位
        var index = if (s[0] == '-' || s[0] == '+') 1 else 0
        while (index < s.length) {
            val c = s[index]
            if (!c.isDigit()) {
                index++
                break // 字符串后面的非数字字符，跳出了
            }
            // 组装数字
            val num = c - '0' // 这一位置的个位数
            // 要考虑整数溢出的情况
            if (ans < Int.MAX_VALUE / 10 || (ans == Int.MAX_VALUE / 10 && num <= Int.MAX_VALUE % 10)) {
                ans = ans * 10 + (c - '0')
            } else {
                // 溢出了
                return if (sign == -1) Int.MIN_VALUE else Int.MAX_VALUE
            }
            index++
        }
        return ans * sign
    }
}