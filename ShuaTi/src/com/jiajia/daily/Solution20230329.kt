package com.jiajia.daily

import java.lang.StringBuilder

class Solution20230329 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230329()
            println(s.countVowelStrings(33))
        }
    }

    var str = StringBuilder();
    var ans = 0
    val chs = charArrayOf('a', 'e', 'i', 'o', 'u')

    fun countVowelStrings(n: Int): Int {
        backTracking(n, 0)
        return ans
    }

    private fun backTracking(n: Int, start: Int) {
        if (str.length >= n) {
            ans++
            return
        }
        // 选择本层的字符
        for (i in start until chs.size) {
            str.append(chs[i])
            backTracking(n, i)
            // 回溯
            str.deleteCharAt(str.length - 1)
        }
    }

}