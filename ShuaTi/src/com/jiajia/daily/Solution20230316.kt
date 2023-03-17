package com.jiajia.daily

import java.util.PriorityQueue

class Solution20230316 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230316()
            println(s.countSubarrays(intArrayOf(2,3,1), 3))
        }
    }

    fun countSubarrays(nums: IntArray, k: Int): Int {
        return method2(nums, k)
    }

    /**
     * 双层for循环 timeout
     */
    private fun method1(nums: IntArray, k: Int): Int {
        var ans = 0
        val queue = ArrayList<Int>()
        for (i in nums.indices) {
            queue.clear()
            for (j in i until nums.size) {
                queue.add(nums[j])
                if (!queue.contains(k)) {
                    continue
                }
                // 包含了k
                queue.sort()
                if (queue.size % 2 == 0) {
                    // 偶数长度
                    if (queue.indexOf(k) == queue.size / 2 - 1) {
                        ans++
                    }
                } else {
                    // 奇数长度
                    if (queue.indexOf(k) == queue.size / 2) {
                        ans++
                    }
                }
            }
        }
        return ans
    }


    /**
     * 优化双层for循环 timeout
     */
    private fun method2(nums: IntArray, k: Int): Int {
        var ans = 0
        for (i in nums.indices) {
            var contain = false
            var min = 0 // <= k的数量
            var max = 0 // > k的数量
            for (j in i until nums.size) {
                if (nums[j] == k) {
                    contain = true
                }

                if (nums[j] <= k) {
                    min++
                } else {
                    max++
                }
                if (!contain) {
                    continue
                }
                ans += if ((j - i + 1) % 2 == 0) {
                    // 偶数
                    if (min == max) 1 else 0
                } else {
                    // 奇数
                    if (min - 1 == max) 1 else 0
                }
            }
        }
        return ans
    }

    /**
     * 数组前缀和的形式
     */
    private fun method3(nums: IntArray, k: Int): Int {
        var ans = 0
        val len = nums.size

        var kIndex = 0
        for (i in nums.indices) {
            if (nums[i] == k) {
                kIndex = i
                break
            }
        }

        val map = HashMap<Int, Int>()
        map[0] = 1
        var preSum = 0
        for (i in nums.indices) {
            preSum += if (nums[i] < k) -1 else if (nums[i] > k) 1 else 0
            if (i < kIndex) {
                // k之前的数
                var cnt = map.getOrDefault(preSum, 0)
                map[preSum] = cnt + 1
            } else {
                // k之后的数
                val prev0 = map.getOrDefault(preSum, 0)
                val prev1 = map.getOrDefault(preSum - 1, 0)
                ans += prev1 + prev0
            }
        }
        return ans
    }

}