package com.jiajia.jingsai

import com.jiajia.kit.ArrayUtils
import java.math.BigDecimal
import java.util.*

class Solution334 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution334()
            ArrayUtils.print(s.leftRigthDifference(intArrayOf(10,4,8,3)))

            ArrayUtils.print(s.divisibilityArray("998244353", 3))

            println(s.maxNumOfMarkedIndices(intArrayOf(3,5,2,4)))
        }
    }

    fun leftRigthDifference(nums: IntArray?): IntArray? {
        if (nums == null || nums.isEmpty()) {
            return nums
        }
        val n = nums.size
        val ans = IntArray(n)
        val preSum = IntArray(n + 1)
        for (i in 1 .. nums.size) {
            preSum[i] = preSum[i - 1] + nums[i - 1]
        }

        for (i in nums.indices) {
            ans[i] = Math.abs(preSum[i] - (preSum[n] - preSum[i + 1]))
        }

        return ans
    }

    /**
     * 6368. 找出字符串的可整除数组(Important)
     */
    fun divisibilityArray(word: String, m: Int): IntArray {
        val len = word.length
        val div = IntArray(len)

        // 依次计算前缀所表示的数值，判断能否被 m 整除
        var prefix = 0L // 使用 long 类型防止溢出
        for (i in 0 until len) {
            prefix = (prefix * 10 + (word[i] - '0')) % m
            if (prefix == 0L) {
                div[i] = 1
            } else {
                div[i] = 0
            }
        }

        // 返回数组 div
        return div
    }

    /**
     * 6367. 求出最多标记下标
     */
    fun maxNumOfMarkedIndices(nums: IntArray): Int {
        var ans = 0
        val n = nums.size
        nums.sort()
        // 最多匹配 n / 2 对，因此二分，前半部分做i，后半部分做j
        var j = n / 2
        for (i in 0 until n / 2) {
            while (j < n && 2 * nums[i] > nums[j]) {
                j++
            }
            if (j < n) {
                ans += 2
                j++
            } else {
                break
            }
        }
        return ans
    }

}