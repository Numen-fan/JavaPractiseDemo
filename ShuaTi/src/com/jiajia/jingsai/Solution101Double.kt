package com.jiajia.jingsai

import com.jiajia.kit.ArrayUtils

class Solution101Double {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution101Double()
            println(s.maximumCostSubstring("kqqqqqkkkq", "kq", intArrayOf(-6, 6)))

            println(s.findShortestCycle(6, ArrayUtils.string2IntArray2("[[4,1],[5,1],[3,2],[5,0],[4,0],[3,0],[2,1]]")))
        }
    }

    fun minNumber(nums1: IntArray, nums2: IntArray): Int {
        nums1.sort()
        nums2.sort()
        val min1 = nums1[0]
        val min2 = nums2[0]

        for (n in nums1) {
            if (nums2.contains(n)) {
                return n
            }
        }

        if (nums1 == nums2) {
           return min1
        } else if (min1 < min2) {
           if (nums1.contains(min2)) {
               return min2
           } else {
               return min1 * 10 + min2
           }
        } else {
            if (nums2.contains(min1)) {
                return min1
            } else {
                return min2 * 10 + min1
            }
        }
    }

    /**
     * 6328. 找到最大开销的子字符串
     */
    fun maximumCostSubstring(s: String, chars: String, vals: IntArray): Int {
        var ans = 0
        var cnt = 0
        for (c in s) {
            val value = getValue(c, chars, vals)
            cnt = if (cnt + value < 0) 0 else cnt + value
            ans = ans.coerceAtLeast(cnt)
        }
        return ans
    }

    private fun getValue(c: Char, chars: String, vals: IntArray): Int {
        return if (chars.contains(c)) {
            vals[chars.indexOf(c)]
        } else {
            c - 'a' + 1
        }
    }

    /**
     * 6330. 图中的最短环
     */
    var ans = -1
    fun findShortestCycle(n: Int, edges: Array<IntArray>): Int {
        var ans = -1
        val map = HashMap<Int, ArrayList<Int>>()
        for (edge in edges) {
            val list1 = map.getOrDefault(edge[0], ArrayList())
            list1.add(edge[1])
            map[edge[0]] = list1
            val list2 = map.getOrDefault(edge[1], ArrayList())
            list2.add(edge[0])
            map[edge[1]] = list2
        }
        for (i in 0 until n) {
            val flag = IntArray(n)
            val length = dfs(map, i, flag, 0, -1)
            if (length != -1) {
                ans = if (ans == -1) length else ans.coerceAtMost(length)
            }
        }
        return ans
    }

    private fun dfs(map: HashMap<Int, ArrayList<Int>>, start: Int, flag: IntArray, len: Int, parent: Int): Int {
        // 递归结束的条件
        if (flag[start] == 1 && len > 2) {
            return len // 找到了环
        }

        if (len >= ans) {
            return len
        }


        if (!map.containsKey(start)) {
            return -1 // 不存在环
        }
        flag[start] = 1
        var len = -1
        val next:ArrayList<Int> = map[start] as ArrayList<Int>
        for (nxt in next) {
            if (nxt != parent) { // 不能回去
//                flag[nxt] = 1
                val l = dfs(map, nxt, flag, len + 1, start)
                len = len.coerceAtMost(l)
            }
        }
        return len
    }

}