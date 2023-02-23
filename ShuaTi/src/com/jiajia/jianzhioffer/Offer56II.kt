package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 */
class Offer56II {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer56II()
            println(o.singleNumber(intArrayOf(3,4,3,3)))
        }
    }

    fun singleNumber(nums: IntArray): Int {
        nums.sort()
        var i = 0
        while (i < nums.size) {
            if (i + 1 < nums.size) {
                if (nums[i] == nums[i + 1]) {
                    i += 3
                    continue
                } else {
                   return nums[i]
                }
            } else {
                return nums[i]
            }
        }
        return nums[0]
    }
}