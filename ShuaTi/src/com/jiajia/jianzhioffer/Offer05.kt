package com.jiajia.jianzhioffer

import java.lang.StringBuilder

/**
 * 剑指 Offer 05. 替换空格
 */
class Offer05 {

    fun replaceSpace(s: String): String {
        val sb = StringBuilder()
        for (c in s.toCharArray()) {
            sb.append(if (c == ' ') "%20" else c)
        }
        return sb.toString()
    }

}