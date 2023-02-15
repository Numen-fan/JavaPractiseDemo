package com.jiajia.daily

import com.jiajia.kit.ArrayUtils

/**
 * 1124. 表现良好的最长时间段
 */
class Solution20230214 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230214()
            println(s.method2(ArrayUtils.string2IntArray("[9,9,6,0,6,6,9]")))
        }
    }
    fun longestWPI(hours: IntArray): Int {
        return method1(hours);
    }

    /**
     * 先尝试暴力求解【不出意料的timeout了】
     */
    private fun method1(hours: IntArray): Int {
        var ans = 0
        for (i in hours.indices) {
            for (j in i until hours.size) {
                var out = 0
                var inner = 0
                for (k in i..j) {
                    if (hours[k] > 8) {
                        out++
                    } else {
                        inner++
                    }
                }
                if (out > inner) {
                    ans = ans.coerceAtLeast(j - i + 1)
                }
            }
        }
        return ans
    }

    /**
     * 前缀和 是可以过的
     */
    private fun method2(hours: IntArray): Int {
        var maxLen = 0
        val preSum = IntArray(hours.size + 1); // 多一个
        for (i in 1 .. hours.size) {
            preSum[i] = preSum[i - 1] + (if (hours[i - 1] > 8) 1 else -1)
        }

        for (i in 0 until preSum.size - 1) {
            for (j in preSum.size - 1 downTo  i + 1) { // 这里可以从后面往前遍历，优化一点
                if (preSum[j] - preSum[i] > 0) {
                    maxLen = maxLen.coerceAtLeast(j - i)
                }
            }
        }

        return maxLen
    }
}