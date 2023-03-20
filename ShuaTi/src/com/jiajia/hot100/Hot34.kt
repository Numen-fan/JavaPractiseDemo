package com.jiajia.hot100

class Hot34 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val h = Hot34()
            println(h.searchRange(intArrayOf(5,7,7,8,8,10), 6).contentToString())
        }
    }


    fun searchRange(nums: IntArray, target: Int): IntArray {
        val ans = intArrayOf(-1, -1)
        if (nums.isEmpty()) {
            return ans
        }
        val index = binarySearch(nums, target)
        var left = index
        var right = index
        while (left - 1 >= 0 && nums[left - 1] == target) {
            left--
        }
        ans[0] = left
        while (right + 1 < nums.size && nums[right + 1] == target) {
            right++
        }
        ans[1] = right
        return ans
    }

    private fun binarySearch(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                return mid
            }
            if (nums[mid] > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return -1;
    }

}