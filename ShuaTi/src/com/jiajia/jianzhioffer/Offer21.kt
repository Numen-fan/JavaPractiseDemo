package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
class Offer21 {

    fun exchange(nums: IntArray): IntArray {
        var left = 0;
        var right = nums.size - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) { // 找到左边第一个不是奇数的下标
                left++
            }

            while (left < right && nums[right] % 2 == 0) {
                right--
            }

            if (left < right) {
                val t = nums[left]
                nums[left] = nums[right]
                nums[right] = t
                nums[left] = nums[left].xor(nums[right])
            }
        }
        return nums
    }
}