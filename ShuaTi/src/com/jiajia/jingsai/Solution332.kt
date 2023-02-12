package com.jiajia.jingsai

import com.jiajia.kit.ArrayUtils

class Solution332 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution332()
            println(s.countFairPairs(ArrayUtils.string2IntArray("[0,0,0,0,0,0]"), 0, 0))
            val arr = Array(2){IntArray(2)}
            arr[0] = intArrayOf(0,5)
            arr[1] = intArrayOf(1,2)
            println(s.substringXorQueries("101101", arr))
        }
    }

    /**
     * 6354. 找出数组的串联值
     */
    fun findTheArrayConcVal(nums: IntArray): Long {
        var left = 0
        var right = nums.size - 1

        var ans: Long = 0
        while (left <= right) {
            if (left == right) {
                ans += nums[left]
            } else {
                ans += (nums[left].toString() + nums[right].toString()).toLong()
            }
            left++
            right--
        }
        return ans
    }

    /**
     * 6355. 统计公平数对的数目
     */
    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
        var ans: Long = 0
        nums.sort() // 从小到大排序，不用考虑下标的顺序

        for (i in 0 until nums.size - 1) {
            val left = getLowerIndex(nums, i + 1, nums.size - 1, lower - nums[i])
            if (left == -1) {
                continue
            }
            val right = getUpperIndex(nums, i + 1, nums.size - 1, upper - nums[i])
            if (right == -1) {
                continue
            }
            ans += right - left + 1
        }
        return ans
    }

    /**
     * 找到比target大的最小值，即value >= target
     */
    private fun getLowerIndex(nums: IntArray, left: Int, right: Int, target: Int): Int {
        nums.find { it >= target }
        var start = left
        var end = right
        var min = -1;
        while (start <= end) {
            val mid = (start + end) / 2
            if (nums[mid] == target) {
                min = min.coerceAtMost(mid)
                end = mid - 1
            }
            if (nums[mid] < target) {
                start = mid + 1
            } else if (nums[mid] > target) {
                end = mid - 1
            }
        }
        if (min != -1) {
            return min
        }
        // 走到这里说明什么呢？？ start > end，并且没有找到 == target, 这时候应该取end
        return if (start < nums.size && nums[start] >= target) start else -1
    }

    /**
     * 找到比target小的最大值，即value <= target
     */
    private fun getUpperIndex(nums: IntArray, left: Int, right: Int, target: Int): Int {
        var start = left
        var end = right
        var max = nums.size
        while (start <= end) {
            val mid = (start + end) / 2
            if (nums[mid] == target) {
                max = max.coerceAtLeast(mid)
                start = mid + 1
            }
            if (nums[mid] < target) {
                start = mid + 1
            } else if (nums[mid] > target) {
                end = mid - 1
            }
        }
        if (max != nums.size) {
            return max
        }
        // 走到这里说明什么呢？？ start > end，并且没有找到 == target, 这时候应该取end
        return if (end > 0 && nums[end] <= target) end else -1
    }

    /**
     * 6356. 子字符串异或查询
     */
    fun substringXorQueries(s: String, queries: Array<IntArray>): Array<IntArray> {
        val ans = Array(queries.size) { IntArray(2) }
        for (k in queries.indices) {
            val query = queries[k]
            ans[k] = intArrayOf(-1, -1)
            for (i in 0 until s.length - 1) {
                var b = false
                for (j in i + 1..s.length) {
                    val str = s.substring(i, j)
                    val a = str.toInt(2)
                    if (query[0] xor a == query[1]) {
                        ans[k] = intArrayOf(i, j - 1)
                        b = true
                        break
                    }
                }
                if (b) {
                    break
                }
            }
        }
        return ans
    }


}