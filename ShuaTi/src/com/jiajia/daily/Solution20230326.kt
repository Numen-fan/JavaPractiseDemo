package com.jiajia.daily

class Solution20230326 {

    fun findSubarrays(nums: IntArray): Boolean {
        val set = HashSet<Int>()
        for (i in 0 until nums.size - 1) {
            if (set.contains(nums[i] + nums[i + 1])) {
                return true
            }
            set.add(nums[i] + nums[i + 1])
        }
        return false
    }

}