package com.jiajia.jianzhioffer

import com.jiajia.kit.ArrayUtils

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
class Offer53 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer53()
            println(o.search(ArrayUtils.string2IntArray("[1,3]"), 1))
        }
    }


    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var l = 0
        var r = nums.size
        var mid = -1
        while (l <= r && r >= 0 && l < nums.size) {
            mid = (l + r) / 2
            if (nums[mid] > target) {
                r = mid - 1
            } else if (nums[mid] < target) {
                l = mid + 1
            } else {
                break
            }
        }

        if (nums[mid] != target) {
            return 0
        }
        // 找到了mid
        var ans = 0;

        for (a in mid until nums.size) {
            if (nums[a] == target) {
                ans++
            } else {
                break
            }
        }

        for (a in mid - 1 downTo  0) {
            if (nums[a] == target) {
                ans++
            } else {
                break
            }
        }
        return ans
    }

}