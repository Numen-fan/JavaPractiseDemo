package com.jiajia.jingsai

import com.jiajia.kit.ArrayUtils
import java.util.PriorityQueue
import kotlin.concurrent.fixedRateTimer

class Solution99Double {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution99Double()
            println(s.splitNum(958351976))
            println(s.countWays(ArrayUtils.string2IntArray2("[[34,56],[28,29],[12,16],[11,48],[28,54],[22,55],[28,41],[41,44]]")))
        }
    }

    /**
     * 6312. 最小和分割
     */
    fun splitNum(num: Int): Int {
        val str = num.toString().replace("0", "")
        val nums = str.toCharArray()
        nums.sort()
        val len = nums.size
        if (len < 2) {
            return nums[0] - '0'
        }
        val mid = len / 2
        val arr1 = CharArray(if(len % 2 == 0) mid else mid + 1)
        val arr2 = CharArray(mid)
        var i = 0
        var j = 0
        var index = 0
        while (index < len) {
            arr1[i++] = nums[index++]
            if (index < len){
                arr2[j++] = nums[index++]
            }
        }
        return Integer.parseInt(String(arr1)) + Integer.parseInt(String(arr2))
    }

    /**
     * 6311. 统计染色格子数
     */
    fun coloredCells(n: Int): Long {
        if (n < 2) {
            return n.toLong()
        }
        return coloredCells(n - 1) + 2 * n + 2*(n - 2)
    }

    /**
     * 6313. 统计将重叠区间合并成组的方案数
     */
    fun countWays(ranges: Array<IntArray>): Int {
        val mod = (1e9 + 7).toInt()
        val queue = PriorityQueue<IntArray> { o1, o2 -> if(o1[0] == o2[0]) o1[1] - o2[1] else o1[0] - o2[0]}
        for (range in ranges) {
            queue.offer(range)
        }

        val dp = IntArray(ranges.size)
        var last = queue.poll()[1]
        dp[0] = 2
        for (i in 1 until ranges.size) {
            val cur = queue.poll()
            dp[i] = if(cur[0] <= last) dp[i - 1] else dp[i - 1] * 2
            dp[i] %= mod
            last = last.coerceAtLeast(cur[1])
        }
        return dp[ranges.size - 1]

    }

}