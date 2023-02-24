package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 */
class Offer39 {
    fun majorityElement(nums: IntArray): Int {
        nums.sort()
        return nums[nums.size / 2]
    }
}