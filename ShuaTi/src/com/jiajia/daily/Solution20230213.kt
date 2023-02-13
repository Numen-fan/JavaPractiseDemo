package com.jiajia.daily

/**
 * 1234. 替换子串得到平衡字符串
 */
class Solution20230213 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230213()
            println(s.balancedString("WWEQERQWQWWRWWERQWEQ"))
        }
    }

    fun balancedString(s: String): Int {
        val arr = IntArray(4)
        for (c in s.toCharArray()) {
            arr[getCharIndex(c)]++
        }
        val cnt = s.length / 4 // 每个字符应该出现的次数
        if (arr[0] <= cnt && arr[1] <= cnt && arr[2] <= cnt && arr[3] <= cnt) {
            return 0 // 初始就是一个平衡串
        }
        var ans = s.length // 默认最大值
        var l = 0 // 窗口左边
        for (r in s.indices) { // 遍历窗口右边
            arr[getCharIndex(s[r])]-- // 窗口中的字符计数-1
            while (l <= r && arr[0] <= cnt && arr[1] <= cnt && arr[2] <= cnt && arr[3] <= cnt) {
                // 窗口外的字符都满足平衡，缩小窗口长度
                ans = ans.coerceAtMost(r - l + 1)
                arr[getCharIndex(s[l])]++ // 左边增大，相应的字符计数加一
                l++ // 窗口左边右滑
            }
        }
        return ans
    }

    private fun getCharIndex(c: Char): Int {
        when (c) {
            'Q' -> return 0
            'W' -> return 1
            'E' -> return 2
            'R' -> return 3
        }
        return -1
    }

}