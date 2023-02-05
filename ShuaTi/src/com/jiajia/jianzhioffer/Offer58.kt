package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 */
class Offer58 {

    fun reverseLeftWords(s: String, n: Int): String {
        val subString = s.substring(0, n)
        return s.substring(n) + subString
    }

}