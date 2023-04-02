package com.jiajia.daily

class Solution20230327 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230327()
            println(s.countSubstrings("ab", "bb"))
        }
    }

    fun countSubstrings(s: String, t: String): Int {
        var ans = 0
        // 罗列所有的子串
        for (i in s.indices) {
            for (j in i + 1 until s.length + 1) {
                val s1 = s.substring(i, j)
                var len = j - i
                // 找t中所有的长度为len的串
                for (k in 0 until t.length - len + 1) {
                    val s2 = t.substring(k, k + len)
                    if (vaild(s1, s2)) {
                        ans++
                    }
                }
            }
        }
        return ans
    }

    private fun vaild(s1: String, s2: String): Boolean {
        if (s1 == s2) {
            return false
        }
        var diff = 0
        for (i in s1.indices) {
            if (s1[i] != s2[i]) {
                diff++
            }
            if (diff > 1) {
                return false
            }
        }
        return true
    }
}