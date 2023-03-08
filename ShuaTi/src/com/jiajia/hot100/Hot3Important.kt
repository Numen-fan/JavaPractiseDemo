package com.jiajia.hot100

/**
 * 3. 无重复字符的最长子串
 */
class Hot3Important {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val h = Hot3Important()
            println(h.lengthOfLongestSubstring("bbbbb"))
        }
    }

    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        var l = 0
        var r = 0
        val count = HashMap<Char, Int>()
        while (r < s.length) {
            val c = s[r]
            val cnt = count.getOrDefault(c, 0)
            if (cnt == 1) {
                // 说明c在前面出现了
                // 更新窗口的长度，此时的区间长度是 l ~ r - 1
                max = max.coerceAtLeast(r - l)
                // 挪动l，直到c
                while (s[l] != c) {
                    count[s[l]] = count[s[l]]!! - 1
                    l++
                }
                // s[l] = c，但是还要向前移动一个
                count[s[l]] = count[s[l]]!! - 1
                l++
            }
            count[s[r]] = 1
            r++
        }
        // 最后一段没有处理
        max = max.coerceAtLeast(r - l) // r = s.length
        return max
    }
}