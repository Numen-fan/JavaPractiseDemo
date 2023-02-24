package com.jiajia.daily

import java.util.PriorityQueue


/**
 * 2357. 使数组中所有元素都等于零
 */
class Solution20230224 {

    fun minimumOperations(nums: IntArray): Int {

        val queue = PriorityQueue<Int>()
        var ans = 0
        for (num in nums) {
            if (num != 0) {
                queue.offer(num)
            }
        }

        while (!queue.isEmpty()) {
            ans++
            val k = queue.poll()
            queue.clear()
            for (i in nums.indices) {
                nums[i] -= k
                if (nums[i] > 0) {
                    queue.add(nums[i])
                }
            }
        }

        return ans
    }

    private fun method(nums: IntArray): Int {
        nums.sort()
        var ans = 0
        while (true) {
            var index = 0
            while (index < nums.size && nums[index] == 0) {
                index++
            }
            // nums[index] 为nums.size或者nums[index] > 0
            if (index >= nums.size) {
                break
            }
            val k = nums[index]
            ans++
            for (i in index until  nums.size) {
                nums[i] -= k
            }
        }
        return ans
    }

}