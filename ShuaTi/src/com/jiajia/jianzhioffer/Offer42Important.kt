package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=b3nqjxj
 */
class Offer42Important {

    fun maxSubArray(nums: IntArray): Int {
        return method1(nums)
    }

    private fun method1(nums: IntArray): Int {
        var ans = nums[0]
        var sum = 0
        for (num in nums) {
            // 只要前面的sum大0，就累加，如果sum小于0，就直接取当前值，下一步比较
            // num开始独立一段，还是并到前面那一段
            sum = num.coerceAtLeast(num + sum)
            ans = ans.coerceAtLeast(sum)
        }
        return ans
    }
}