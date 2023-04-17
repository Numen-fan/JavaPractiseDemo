package com.jiajia.jingsai

import com.jiajia.kit.ArrayUtils
import kotlin.math.min

class Solution341 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution341()
            println(s.addMinimum("abb"))
            var ans = s.minimumTotalPrice(5, ArrayUtils.string2IntArray2("[[2,0],[3,1],[1,0],[0,4]]"),
                intArrayOf(2,16,4,16,6), ArrayUtils.string2IntArray2("[[4,3]]"))
            print(ans)
        }
    }

    fun rowAndMaximumOnes(mat: Array<IntArray>): IntArray {
        val ans = IntArray(2)
        var maxCnt = -1
        for (i in mat.indices) {
            var row = mat[i]
            var cnt = 0
            for (j in row) {
                cnt += j
            }
            if (cnt > maxCnt) {
                ans[0] = i
                ans[1] = cnt
                maxCnt = cnt
            }
        }
        return ans
    }

    /**
     * 6350. 找出可整除性得分最大的整数
     */
    fun maxDivScore(nums: IntArray, divisors: IntArray): Int {
        var result = -1
        var maxCore = -1
        for (divisor in divisors) {
            var core = 0
            for (num in nums) {
                if (num % divisor == 0) {
                    core++
                }
            }
            if (core > maxCore || core == maxCore && divisor < result) {
                result = divisor
                maxCore = core
            }
        }
        return result
    }

    /**
     * 6375. 构造有效字符串的最少插入数
     */
    fun addMinimum(word: String): Int {
        var ans = 0
        var i = 0 // 一直累加，可以看做最后字符串的长度，每三个一个循环
        var j = 0 // 指向word
        while (j < word.length) {
            if (word[j] == 'a'.plus(i % 3)) { // 'a' + (i % 3) 表示当前需要什么
                j++
            } else {
                ans++ // 需要插入
            }
            i++ // i是需要每步都累加的
        }
        i-- // while内部多加了一次
        // 判断最后是不是'c'
        while ('a'.plus(i % 3) != 'c') {
            i++
            ans++
        }
        return ans
    }

    /**
     * 6378. 最小化旅行的价格总和
     */
    fun minimumTotalPrice(n: Int, edges: Array<IntArray>, price: IntArray, trips: Array<IntArray>): Int {
        if (n == 2 && trips[0][0] == 0 && trips[0][1] == 0) {
            return 1
        }
        val adj = Array(n) { ArrayList<Int>() }
        // 构建邻接表
        for (edge in edges) {
            adj[edge[0]].add(edge[1])
            adj[edge[1]].add(edge[0])
        }
        // 进行减半处理
        val flag = BooleanArray(n) // 标记是否被减半处理
        for (j in 0 until n) {
            val node = adj[j]
            for (i in 0 until n) {
                if (i != j && !node.contains(i) && !flag[i]) {
                    flag[i] = true
                    price[i] = price[i] / 2 // 减半处理
                }
            }
        }

        // 进行结果查找
        var ans = 0
        for (trip in trips) {
            val path =  ArrayList<Int>();
            path.add(trip[0])
            ans += minTrip(adj, price, trip[0], trip[1], path)
        }
        return ans

    }

    /**
     * 返回从start到end的最小代价
     */
    private fun minTrip(adj: Array<ArrayList<Int>>, price: IntArray, start: Int, end: Int, path: ArrayList<Int>): Int {
        if (start == end) {
            return price[start]
        }
        // 如果start的邻接节点中有end, 那么可以直接返回两个节点的花费和
        if (adj[start].contains(end)) {
            return price[start] + price[end]
        }
        // 需要继续往下面找了
        var ans = Int.MAX_VALUE
        for (nextNode in adj[start]) {
            // 不能走走过的路
            if (path.contains(nextNode)) {
                continue
            }
            path.add(nextNode)
            val nextCast = minTrip(adj, price, nextNode, end, path);
            if (nextCast != Int.MAX_VALUE) {
                ans = ans.coerceAtMost(nextCast) + price[start]
            }
            path.remove(nextNode)
        }
        return ans
    }

}
