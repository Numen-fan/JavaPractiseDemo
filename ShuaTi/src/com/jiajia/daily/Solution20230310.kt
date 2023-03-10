package com.jiajia.daily

/**
 * 1590. 使数组和能被 P 整除
 */
class Solution20230310 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val  s = Solution20230310()
            println(s.minSubarray(intArrayOf(8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2), 148))
        }
    }

    fun minSubarray(nums: IntArray, p: Int): Int {
        var sum = 0 // 所有元素对p mod的和
        for (num in nums) {
            sum = (sum + num) % p
        }

        if (sum % p == 0) {
            return 0 // 整个数组元素的和是p的整数倍，不需要移除
        }

        var ans = nums.size
        val map = HashMap<Int, Int>()
        val preSum = IntArray(nums.size + 1)
        map[0] = -1 // target = 0的下标
        for (j in nums.indices) {
            preSum[j + 1] = (preSum[j] + nums[j]) % p // 前缀和
            val target = (preSum[j + 1] - sum + p) % p // 需要查找前面某个位置，是否有这个前缀和的值
            if (map.containsKey(target)) {
                ans = ans.coerceAtMost(j - map[target]!!)
            }
            map[preSum[j + 1]] = j // 可以直接覆盖，因为是求最小的子数组长度
        }

        return if (ans == nums.size) -1 else ans

    }

}