package com.jiajia.hot100

class Hot215 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val h = Hot215()
            val nums = intArrayOf(2, 3, 1, 6, 3, 4, 2)
            println(h.method2(nums, 2))
            println(h.method1(nums, 2))
        }
    }

    fun findKthLargest(nums: IntArray, k: Int): Int {
        return method1(nums, k)
    }


    /**
     * 采用计数排序的方法
     * 对所有的元素进行计数，然后从后往遍历，用k-元素的计数，直到将k减小到<= 0，说明当前这个数就是了
     */
    private fun method1(nums: IntArray, k: Int): Int {
        val offset = 10000
        val count = IntArray(200001)
        for (num in nums) {
            count[num + offset]++ // 计数, 出现的次数
        }

        var t = k
        for (i in count.size - 1 downTo 0) { // 从后向前
            t -= count[i]
            if (t <= 0) {
                return i - offset
            }
        }
        return 0
    }

    /**
     * 基于快速排序的查找方法
     */
    private fun method2(nums: IntArray, k: Int): Int {
        return quickSort(nums, 0, nums.size - 1, k)
    }

    /**
     * 先实现快排
     * 第k大的元素，在升序排列中的下标为n - k, 比如第一大为n-1，即最后一个元素，这就是我们要寻找的目标位置
     */
    private fun quickSort(nums: IntArray, left: Int, right: Int, k: Int): Int {
        if (left >= right) {
            return nums[left]
        }
        val pivot = nums[left] // 最左边的基准元素
        var i = left // 左指针 // 左边位置空了
        var j = right // 右指针
        while (i < j) {
            // 先在右边找到比pivot小的元素
            while (j > i && nums[j] >= pivot) {
                j--
            }
            if (j > i) {
                nums[i] = nums[j]
                // 继续从左往右找到第一个大于pivot的元素
                while (j > i && nums[i] < pivot) {
                    i++
                }
                if (i < j) {
                    nums[j] = nums[i]
                }
            }
        }

        // i==j
        nums[i] = pivot // 基准元素落位， 这个地方就知道了i位置了
        return if (i == nums.size - k) {
            // 找到位置
            println("找到目标数 = ${nums[i]}")
            nums[i] // 这就是目标数
        } else {
            // 这里分左右进行查找就可以了
            if (i < nums.size - k) {
                // 说明要去右边找
                quickSort(nums, i + 1, right, k)
            } else {
                quickSort(nums, left, i, k)
            }
        }
    }
}