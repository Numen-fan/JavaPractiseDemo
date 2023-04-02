package com.jiajia.jingsai

import kotlin.test.assertNotEquals

class Solution338 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution338()
            println(s.primeSubOperation(intArrayOf(5, 13, 4, 13)))
            println(s.minOperations(intArrayOf(59,38,85,19,76,77,41,56,98,51,99,2,83,3,23,80,51,51,55,3,95,80,24,69,94,88,3,85,100,69,45,80,95,27,17,65,91,56,11,6,94,81,85,35,13,3,43,90,39,21,24,40,68,30,64,22,77,93,43,28,16,61,93,40,69,91,36,21,17,25,83,37,67,72,96,58,52), intArrayOf(1)))
            println(s.minOperations(intArrayOf(2,9,6,3), intArrayOf(10)))
        }
    }

    fun kItemsWithMaximumSum(numOnes: Int, numZeros: Int, numNegOnes: Int, k: Int): Int {
        if (numOnes >= k) {
            return k
        } else if (numOnes + numZeros >= k) {
            return numOnes
        } else {
            // -1的件数
            val n = k - (numOnes + numZeros)
            return numOnes - n
        }
    }

    /**
     * 6355. 质数减法运算
     */
    fun primeSubOperation(nums: IntArray): Boolean {
        for (i in nums.indices) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                return false // 已经不可能了
            }
            val maxN = if (i > 0) nums[i] - nums[i - 1] else nums[i]
            for (n in maxN - 1 downTo 2) {
                if (isPrime(n)) {
                    nums[i] -= n
                    break
                }
            }
            if (i > 0 && nums[i] <= nums[i - 1]) {
                return false
            }
        }
        return true
    }

    private fun isPrime(num: Int): Boolean {
        if (num <= 3) {
            return num > 1
        }
        for (i in 2 until num / 2 + 1) {
            if (num % i == 0) {
                return false
            }
        }
        return true
    }

    /**
     * 6357. 使数组元素全部相等的最少操作次数
     */
    fun minOperations(nums: IntArray, queries: IntArray): List<Long> {
        nums.sort()
        val preSum = LongArray(nums.size + 1) // 前缀和
        for (i in nums.indices) {
            preSum[i + 1] = preSum[i] + nums[i]
        }
        val ans = ArrayList<Long>()
        for (q in queries) {
            if (q <= nums[0]) {
                ans.add(preSum[preSum.size - 1] - nums.size * q)
                continue
            }
            if (q >= nums[nums.size - 1]) {
                ans.add(nums.size * q - preSum[preSum.size - 1])
                continue
            }
            val index: Int = binarySearch(nums, q) // 最接近q的下标, 0 ~ index - 1 小于q index  ~ mums.size > q
            var cnt: Long = index.toLong() * q.toLong() - preSum[index] // 0 ~ index的和
            cnt += preSum[preSum.size -  1] - preSum[index] - (nums.size - index).toLong() * q.toLong()
            ans.add(cnt)
        }
        return ans
    }

    /**
     * 返回第一个大于q的元素下标
     */
    private fun binarySearch(nums: IntArray, q: Int): Int {
        var l = 1
        var r = nums.size - 1
        while (l < r) {
            val mid = (r - l) / 2 + l;
            if (nums[mid] > q) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        return r
    }


}