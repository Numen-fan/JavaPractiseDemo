package com.jiajia.daily

class Solution20230227 {

    fun movesToMakeZigzag(nums: IntArray): Int {
        val res = IntArray(2)
        for (i in nums.indices) {
            val left = if(i > 0) nums[i - 1] else Int.MAX_VALUE
            val right = if(i < nums.size - 1) nums[i + 1] else Int.MAX_VALUE
            res[i % 2] += (nums[i] - left.coerceAtMost(right) + 1).coerceAtLeast(0)
        }
        return res[0].coerceAtMost(res[1])
    }

}