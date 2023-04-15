package com.jiajia.daily

class Solution20230414 {

    fun camelMatch(queries: Array<String>, pattern: String): List<Boolean> {
        val ans = ArrayList<Boolean>()
        for (query in queries) {
            ans.add(match(query, pattern))
        }
        return ans
    }

    private fun match(str: String, pattern: String): Boolean {
        var i = 0
        var p = 0
        while (i < str.length) {
            if (p < pattern.length && str[i] == pattern[p]) { // 两个字符相等，则模式串下标后移动
                p++
            } else if (str[i].isUpperCase()) { // 不等的时候，str[i]又是一个大写字母，则认为不可能
                return false
            }
            i++
        }
        return p == pattern.length // pattern需要完全匹配结束
    }
}