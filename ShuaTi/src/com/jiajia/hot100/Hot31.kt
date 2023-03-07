package com.jiajia.hot100

class Hot31 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val h = Hot31()
            val nums = intArrayOf(1,2,3)
            h.nextPermutation(nums)
            println(nums.contentToString())
        }
    }

    fun nextPermutation(nums: IntArray): Unit {
        if (nums.size < 2) {
            return
        }
        // 从和面往前面找一个逆序序列，知道
        // 如果i找到1还没找到，那说明整体逆序，此时要完全翻转
        for (i in nums.size - 1 downTo 1) {
            if (nums[i] <= nums[i - 1]) {
                continue
            }
            // 此时nums[i] > nums[i - 1], i-1之前保持不动
            // 从后向前找到第一个比nums[i-1]大的数字nums[j]，交换
            // 交换之后，对 i ~ nums.size - 1的元素进行逆转
            for (j in nums.size - 1 downTo i) {
                if (nums[j] > nums[i - 1]) {
                    // 交换
                    var t = nums[i - 1]
                    nums[i - 1] = nums[j]
                    nums[j] = t
                    // 对i~nums.size - 1的元素进行逆转
                    var l = i
                    var r = nums.size - 1
                    while (l < r) {
                        t = nums[l]
                        nums[l] = nums[r]
                        nums[r] = t
                        r--
                        l++
                    }
                    return
                }
            }
        }
        // 说明原始数组逆序，
        for (i in 0 until nums.size / 2) {
            // 交换即可
            val t = nums[i]
            nums[i] = nums[nums.size - i - 1]
            nums[nums.size - i - 1] = t
        }
    }
}