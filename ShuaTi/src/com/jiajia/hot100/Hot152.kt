package com.jiajia.hot100

class Hot152 {

    fun maxProduct(nums: IntArray): Int {
        var a = 1
        var max = 0
        for (n in nums) {
            a *= n
            max = max.coerceAtLeast(a)
            if (n == 0) {
                a = 1
            }
        }

        a = 1
        for (i in nums.size - 1 downTo 0) {
            a *= nums[i]
            max = max.coerceAtLeast(a)
            if (nums[i] == 0) {
                a = 1
            }
        }
        return max
    }

}