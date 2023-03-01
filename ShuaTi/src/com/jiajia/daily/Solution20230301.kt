package com.jiajia.daily

class Solution20230301 {

    fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
        val n: Int = grid.size
        val m = n - 2
        val ans = Array(m) { IntArray(m) }

        for (i in 0 until m) { // 控制行
            for (j in 0 until m) { // 控制列

                // 遍历原始二维数组
                var maxValue = Int.MIN_VALUE
                for (k in i until i + 3) {
                    for (p in j until j + 3) {
                        maxValue = Math.max(maxValue, grid.get(k).get(p))
                    }
                }
                ans[i][j] = maxValue
            }
        }

        return ans
    }

}