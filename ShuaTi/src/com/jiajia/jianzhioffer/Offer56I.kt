package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 */
class Offer56I {

    fun singleNumbers(nums: IntArray): IntArray {
        nums.sort()
        val ans = IntArray(2)
        var i = 0
        var index = 0
        while (i < nums.size) {
            if (i + 1 < nums.size) {
                if (nums[i] == nums[i + 1]) {
                    i += 2
                    continue
                } else {
                    ans[index] = nums[i]
                    index++
                    i++
                }
            } else {
                ans[index] = nums[i]
                i++
            }
        }
        return ans
    }
}