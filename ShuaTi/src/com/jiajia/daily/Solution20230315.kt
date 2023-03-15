package com.jiajia.daily

import com.jiajia.kit.ArrayUtils

class Solution20230315 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230315()
            println(s.maximalNetworkRank(8, ArrayUtils.string2IntArray2("[[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]")))
        }
    }

    fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
        // 数据处理
        val roadArr = Array(n) { HashSet<Int>() }
        for ((i, o) in roads) {
            var set = roadArr[i]
            set.add(o)
            set =  roadArr[o]
            set.add(i)
        }
        var ans = 0

        for (i in 0 until n) {
            for (j in i + 1 until n) {
                val cross = roadArr[i].contains(j)
                ans = ans.coerceAtLeast(roadArr[i].size + roadArr[j].size - if (cross) 1 else 0)
            }
        }

        return ans
    }

}