package com.jiajia.daily

class Solution20230422 {

    fun longestArithSeqLength(nums: IntArray): Int {
        var ans = 2
        for (i in nums.indices) { // 子数组的第一个元素
            for (j in i + 1 until nums.size) { // 子数组的第二个元素
                var diff = nums[i] - nums[j] // 等差值
                var len = 1
                // 下一步要寻找的目标target值
                var next = j
                var target = nums[i] - diff
                for (k in j until nums.size) {
                    if (nums[k] == target) {
                        // 找到目标值，更新len和target
                        len++
                        target -= diff // 下一个目标值
                    }
                }
                ans = ans.coerceAtLeast(len)
            }
        }

        return ans

    }

}