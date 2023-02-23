package com.jiajia.daily

/**
 * 1238. 循环码排列
 */
class Solution20230223 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230223()
            println(s.circularPermutation(7, 12))
        }
    }


    private val used = ArrayList<Int>() // 记录已经用过的数字
    private val map = HashMap<Int, ArrayList<Int>>() // key所对应的相差一位的数字集合

    fun circularPermutation(n: Int, start: Int): List<Int> {
        val list = ArrayList<Int>()
        // 初始化数组
        val len = 1 shl n
        val nums = IntArray(len)
        for (i in nums.indices) {
            nums[i] = i
        }

        // 初始化map
        for (i in 0 .. len - 2) {
            for (j in i until len) {
                if (isMatch(i, j)) {
                    val list1 = map.getOrDefault(i, ArrayList())
                    list1.add(j)
                    map[i] = list1
                    // 同样j也满足
                    val list2 = map.getOrDefault(j, ArrayList())
                    list2.add(i)
                    map[j] = list2
                }
            }
        }

        list.add(start)
        used.add(start)
        backTracking(nums, list)
        return list
    }

    private fun backTracking(nums: IntArray, list: ArrayList<Int>): Boolean {
        if (list.size >= nums.size) {
             // 已经找到了结果
            return isMatch(list[0], list.last())
        }

        // 本层需要选择的数据
        val n = list.last() // 前一个数据
        val l = map[n]

        if (l.isNullOrEmpty()) {
            return false
        }

        for (num in l) {
            if (used.contains(num)) {
                continue
            }
            // 尝试选择num
            used.add(num)
            list.add(num)
            if (backTracking(nums, list)) {
                return true
            }
            // 不满足，开始回溯
            used.remove(num)
            list.remove(num)
        }
        return false
    }

    private fun isMatch(a: Int, b: Int): Boolean {
        var c = a xor b // 异或运算
        // 判断c中是否只有一个1
        return c and (c - 1) == 0
    }
}