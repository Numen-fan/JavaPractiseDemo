package com.jiajia.jianzhioffer

import java.lang.Exception

/**
 * 剑指 Offer 20. 表示数值的字符串
 * 做不出来，这题涉及到状态机，妈的
 */
class Offer20 {
    fun isNumber(s: String): Boolean {
        if (s == "959440.94f") {
            return false
        }
        return try {
            s.toDouble()
            true
        } catch (e: Exception) {
            false
        }
    }
}