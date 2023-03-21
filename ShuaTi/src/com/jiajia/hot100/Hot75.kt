package com.jiajia.hot100

class Hot75 {

    fun sortColors(nums: IntArray): Unit {
        var count0 = 0
        var count1 = 0
        for (num in nums) {
            if (num == 0) {
                count0++
            } else if (num == 1) {
                count1++
            }
        }

        for (i in 0 until count0) {
            nums[i] = 0
        }

        for (i in count0 until count0 + count1) {
            nums[i] = 1
        }

        for (i in count0 + count1 until nums.size) {
            nums[i] = 2
        }
    }

    private fun method(nums: IntArray): Unit {
        var ptr = 0
        for (i in nums.indices) {
            if (nums[i] == 0) { // 将所有的0放在头部
                val t = nums[ptr]
                nums[ptr] = nums[i]
                nums[i] = t
                ptr++
            }
        }

        for (i in nums.indices) { // 将所有的1放在中部
            if (nums[i] == 1) {
                val t = nums[ptr]
                nums[ptr] = nums[i]
                nums[i] = t
                ptr++
            }
        }
    }

}