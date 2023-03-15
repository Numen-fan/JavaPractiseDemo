package com.jiajia.hot100

class Hot16 {

//    val sumSet = HashSet<Int>()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val h = Hot16()
            println(h.threeSumClosest(intArrayOf(4,0,5,-5,3,3,0,-4,-5), -2))
        }
    }

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        // 首先进行升序排序
        nums.sort()
        println("排序后 ${nums.contentToString()}")
        // 排序后，从左往右依次固定一个位置nums[i],
        // 然后设置双指针left和right, 不断去寻找nums[left] + nums[right] 接近target - nums[i]
        // 如果可以找到nums[left] + nums[right] == target - nums[i], 则直接返回target
        // 这个过程不断记录最小的nums[left] + nums[right] + nums[i]

        var ans = target
        val n = nums.size
        var lastDistance = Int.MAX_VALUE // 确保内部一定可以进去

        for (i in 0 until n - 2) {
            // 固定位置nums[i]
            val tempTarget = target - nums[i]
            println("寻找临时目标 => $tempTarget")
            var left = i + 1
            var right = n - 1
            while (left < right) { // left和right是不可以相交的
                val sum = nums[left] + nums[right]
                print("$sum ")
                if (sum == tempTarget) {
                    return target // 存在三个数，和完全等于target
                }

                // 计算最当前的接近程度
                if (lastDistance > Math.abs(sum + nums[i] - target)) {
                    lastDistance = Math.abs(sum + nums[i] - target)
                    ans = sum + nums[i]
                }

                // 这地方不用二分了，直接左右移动, 二分不好处理边界
//                // 继续左右找
//                val mid = (left + right) / 2
//                if (sum < tempTarget && left != mid) {
//                    // 往右边找
//                    left = mid
//                } else {
//                    right = mid - 1
//                }
                if (sum > tempTarget) {
                    val tempRight = nums[right]
                    while (left < right && nums[right] == tempRight) {
                        right--
                    }
                } else {
                    val tempLeft = nums[left]
                    while (left < right && nums[left] == tempLeft) {
                        left++
                    }
                }
            }
            println()
        }

        return ans

    }

}