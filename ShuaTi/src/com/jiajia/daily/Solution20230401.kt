package com.jiajia.daily

import java.lang.StringBuilder

class Solution20230401 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230401()
            println(s.maskPII("1(234)567-890"))
        }
    }


    fun maskPII(s: String): String {
        if (s.contains('@')) {
            // 邮件
            val sb = StringBuilder()
            val atIndex = s.indexOf('@')
            // 第一位
            sb.append(if (s[0].isUpperCase()) 'a' + (s[0] - 'A') else s[0])
            sb.append("*****")
            sb.append(if (s[atIndex - 1].isUpperCase()) 'a' + (s[atIndex - 1] - 'A') else s[atIndex - 1])
            sb.append('@')
            for (i in atIndex + 1 until s.length) {
                sb.append(if (s[i].isUpperCase()) 'a' + (s[i] - 'A') else s[i])
            }
            return sb.toString()
        } else {
            // 电话
            val sb = StringBuilder()
            val s = s.replace("+", "").replace("-", "").replace("(", "").replace(")", "")
                .replace(" ", "")
            println(s)
            if (s.length == 10) {
                sb.append("***-***-").append(s.substring(s.length - 4))
            } else if(s.length == 11) {
                sb.append("+*-***-***-").append(s.substring(s.length - 4))
            } else if (s.length == 12) {
                sb.append("+**-***-***-").append(s.substring(s.length - 4))
            } else {
                sb.append("+***-***-***-").append(s.substring(s.length - 4))
            }
            return sb.toString()
        }
    }
}