package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 03. 数组中重复的数字
 */
class Offer03 {

    fun findRepeatNumber(nums: IntArray): Int {
        val arr = IntArray(nums.size)
        for (num in nums) {
            arr[num]++;
            if (arr[num] > 1) {
                return num;
            }
        }
        return -1;
    }


}