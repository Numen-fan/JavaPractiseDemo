package com.jiajia.hot100

import kotlin.math.max

class Hot128 {

    fun longestConsecutive(nums: IntArray): Int {
        val set = HashSet<Int>();
        for (num in nums) {
            set.add(num)
        }
        var maxLength = 0
        // 枚举每个num为起点的区间
        for (num in nums) {
            if (set.contains(num - 1)) {
                continue // 【关键】不需要重复去判断，即使num-1在后面，也交给遍历到num - 1的时候再去处理
            }
            var curLength = 1
            var curNum = num
            while (set.contains(curNum + 1)) {
                curLength++
                curNum++
            }
            maxLength = maxLength.coerceAtLeast(curLength)
        }
        return maxLength
    }

}