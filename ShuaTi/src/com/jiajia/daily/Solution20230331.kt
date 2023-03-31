package com.jiajia.daily

class Solution20230331 {

    fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
        var ans = 0
        for (i in 0 until nums.size - 2) {
            for (j in i + 1 until  nums.size - 1) {
                if (nums[j] - nums[i] > diff) {
                    break
                }
                if (nums[j] - nums[i] ==diff) {
                    for (k in j + 1 until nums.size) {
                        if (nums[k] - nums[j] > diff) {
                            break
                        }
                        if (nums[k] - nums[j] == diff) {
                            ans++
                        }
                    }
                }
            }
        }
        return ans

    }

    private fun method(nums: IntArray, diff: Int): Int {
        val set = HashSet<Int>()
        var ans = 0
        for (num in nums) {
            set.add(num)
            if (set.contains(num - diff) && set.contains(num - 2 * diff)) { // 三元组[num - 2diff, num - diff, num]
                ans++
            }
        }
        return ans
    }

}