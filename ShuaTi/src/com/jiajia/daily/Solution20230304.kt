package com.jiajia.daily

/**
 * 982. 按位与为零的三元组
 */
class Solution20230304 {

    var count = 0
    val path = ArrayList<Int>()
    fun countTriplets(nums: IntArray): Int {
        backTracking(nums, 0)
        return count
    }

    /**
     * 递归，超时
     */
    private fun backTracking(nums: IntArray, start: Int) {
        if (path.size == 3) {
            if (path[0] and path[1] and path[2] == 0) {
                count++
            }
            return
        }
        for (i in nums) {
            path.add(i)
            backTracking(nums, i)
            // 回溯
            path.removeAt(path.size - 1)
        }
    }

    /**
     * hash解法
     */
    private fun method(nums: IntArray): Int {
        val map = HashMap<Int, Int>() // key为两个数的与结果，value为出现次数
        for (i in nums) {
            for (j in nums) {
                val t = i and j
                val cnt = map.getOrDefault(t, 0)
                map[t] = cnt + 1
            }
        }

        var ans = 0
        for (l in nums) {
            for ((k,v) in map) {
                if (l and k == 0) {
                    ans += map[k]!!
                }
            }
        }

        return ans
    }
}