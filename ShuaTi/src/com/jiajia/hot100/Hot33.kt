package com.jiajia.hot100

class Hot33 {

    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        if (nums[left] <= target) {
            // 那么target可能出现在前部分
            while (left < nums.size && nums[left] < target) {
                left++
            }
            if (left < nums.size && nums[left] == target) {
                return left
            }
        } else {
            // target <= nums[right] 在数组的后半部分
            while (right >= 0 && nums[right] > target) {
                right--
            }
            if (right >= 0 && nums[right] == target) {
                return right
            }
        }
        return -1

    }

}