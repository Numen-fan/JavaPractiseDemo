package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 57. 和为s的两个数字
 */
class Offer57 {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        var left = 0;
        var right = nums.size - 1;
        val ans = intArrayOf(0, 0)
        while (left < right) {
            while (left < right && nums[left] + nums[right] < target) {
                left++
            }

            while (right > left && nums[right] + nums[left] > target) {
                right--
            }
            if (left < right && nums[left] + nums[right] == target) {
                ans[0] = nums[left]
                ans[1] = nums[right]
                break
            }
        }
        return ans
    }


}