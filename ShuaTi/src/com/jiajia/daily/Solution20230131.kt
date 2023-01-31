package com.jiajia.daily

import com.jiajia.kit.ArrayUtils

/**
 * 2319. 判断矩阵是否是一个 X 矩阵
 */
class Solution20230131 {

    fun checkXMatrix(grid: Array<IntArray>): Boolean {
        val n = grid.size;
        // 判断每行每列的每个元素
        // 对于[i, j] 需要判断是否是对角线元素
        // 如果i==j 或者i+j = n - 1则是对角线元素
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == j || i + j == n - 1) { // 对角线元素
                    if (grid[i][j] == 0) {
                        return false
                    }
                } else if (grid[i][j] != 0) { // 非对角线元素
                    return false
                }
            }
        }

        return true
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            var s = Solution20230131()
            println(s.checkXMatrix(ArrayUtils.string2IntArray2("[]")))
        }

    }
}