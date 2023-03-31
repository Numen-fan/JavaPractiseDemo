package com.jiajia.hot100

class Hot15 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val h = Hot15()
            println(h.threeSum2(intArrayOf(-2,0,1,1,2)))
        }
    }

    val ans = ArrayList<List<Int>>()
    val path = ArrayList<Int>()
    val strSet = HashSet<String>();

    fun threeSum(nums: IntArray): List<List<Int>> {
        backTracking(nums, 0)
        return ans
    }


    /**
     * 回溯，timeout
     */
    private fun backTracking(nums: IntArray, start: Int): Boolean {
        if (path.size == 3) {
            if (path.sum() == 0) {
                val t = ArrayList(path);
                t.sort()
                val s = t.joinToString()
                if (!strSet.contains(s)) {
                    ans.add(t)
                    strSet.add(s)
                }
                return true // 说明到位了
            }
            return false
        }

        if (start >= nums.size) {
            return false
        }

        for (i in start until nums.size) {
            path.add(nums[i])

            val match = backTracking(nums, i + 1);
            // 回溯
            path.removeAt(path.size - 1)

            if (match) {
                break // 没有必要再继续找下去了
            }
        }
        return false
    }

    /**
     * accept
     */
    fun threeSum2(nums: IntArray): List<List<Int>> {
        val ans = ArrayList<List<Int>>()
        nums.sort() // 从小到大排序
        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            if (nums[i] > 0) { // 第一个不能是正数了
                break
            }
            for (j in i + 1 until nums.size - 1) {
                if (j > i + 1 && nums[j] == nums[j - 1]) { // 需要注意这里的j > i + 1
                    continue
                }
                val index = binarySearch(nums, j + 1, 0 - nums[i] - nums[j])
                if (index != -1) {
                    ans.add(listOf(nums[i], nums[j], nums[index]))
                }
            }
        }
        return ans
    }

    private fun binarySearch(nums: IntArray, start: Int, target: Int): Int {
        var right = nums.size - 1
        var left = start
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return -1
    }
}