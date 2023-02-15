package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 */
class Offer58I {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer58I()
            println(o.reverseWords("a good   example"))
        }
    }

    fun reverseWords(s: String): String {
        val strArr = s.split(" ").filter { it.isNotEmpty() }.toTypedArray()

        var left = 0
        var right = strArr.size - 1

        while (left < right) {
            val temp = strArr[left]
            strArr[left] = strArr[right]
            strArr[right] =temp
            left++
            right--
        }
        return strArr.joinToString(separator = " ")
    }

}