package com.jiajia.jianzhioffer

import java.util.*

/**
 * 指 Offer 53 - II. 0～n-1中缺失的数字
 */
class Offer53II {

    fun missingNumber(nums: IntArray): Int {
        Arrays.sort(nums)
        if (nums[0] != 0) {
            return 0
        }

        val n = nums.size; // 最大数
        if (nums[n - 1] != n) {
            return n
        }

        for (i in 1 until nums.size) {
            if (nums[i] - nums[i - 1] > 1) {
                return nums[i] - 1;
            }
        }
        return -1;
    }

}