package com.jiajia.daily

class Solution20230317 {

    fun answerQueries(nums: IntArray, queries: IntArray): IntArray {
        nums.sort()

        val preSum = IntArray(nums.size + 1)
        for (i in nums.indices) {
            preSum[i + 1] = preSum[i] + nums[i]
        }

        val ans = IntArray(queries.size)
        for (i in queries.indices) {
            ans[i] = getMaxSubArrLength2(preSum, queries[i])
        }
        return ans
    }

    /**
     * 每次都重复计算了
     */
    private fun getMaxSubArrLength(nums: IntArray, target: Int): Int {
        var ans = 0
        var cnt = 0
        for (i in nums.indices) {
            cnt += nums[i]
            if (cnt > target) {
                ans = i // 下标i已经不满足，所以长度就是0~i-1， 长度就是i
                break
            } else if (i == nums.size - 1) {
                // 说明整个数组都满足
                ans = nums.size
                break
            }
        }
        return ans
    }

    /**
     * 每次都重复计算了
     */
    private fun getMaxSubArrLength2(preSum: IntArray, target: Int): Int {
        var i = 1
        while (i < preSum.size && preSum[i] <= target) {
            i++
        }
        return i - 1
    }
}