package com.jiajia.daily

import com.jiajia.kit.ArrayUtils

/**
 * 1139. 最大的以 1 为边界的正方形
 */
class Solution20230217 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230217()
            println(s.largest1BorderedSquare2(ArrayUtils.string2IntArray2("[[1,1,0],[1,1,1],[1,1,1],[1,1,1]]")))
        }
    }

    fun largest1BorderedSquare(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val limit = m.coerceAtMost(n) // 最长的正方形边长

        // 遍历正方形的左上角坐标 和 长度
        for (len in limit downTo 1) { // 这个地方要在纸上画一下，才能更加清晰的掌握
            for (i in 0..m - len) {
                for (j in 0..n - len) {
                    if (check(grid, i, j, len)) {
                        return len * len
                    }
                }
            }
        }
        return 0
    }

    /**
     * 校验当前的左上角点坐标和边长是否满足正方形，即边长上都是1
     * @param row 左上角的行
     * @param col 左上角的列
     * @param len 边长
     */
    private fun check(grid: Array<IntArray>, row: Int, col: Int, len: Int): Boolean {
        // 先看水平上下两边是否都是1，行不变
        for (i in col until col + len) {
            if (grid[row][i] != 1) {
                return false
            }
            if (grid[row + len - 1][i] != 1) {
                return false
            }
        }

        // 再看垂直左右两边是否都是1, 列不变
        for (i in row until row + len) {
            if (grid[i][col] != 1) {
                return false
            }

            if (grid[i][col + len - 1] != 1) {
                return false
            }
        }

        return true
    }

    /**
     * 用前缀和优化一下
     */
    fun largest1BorderedSquare2(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val limit = m.coerceAtMost(n) // 最长的正方形边长

        val preRowFix = Array(m) {IntArray(n + 1)} // 每行的前缀和
        val preColFix = Array(n) {IntArray(m + 1)} // 每列的前缀和
        for (i in 0 until  m) {
            for (j in 0 until  n) {
                preRowFix[i][j + 1] = preRowFix[i][j] + grid[i][j]
                preColFix[j][i + 1] = preColFix[j][i] + grid[i][j]
            }
        }

        // 遍历正方形的左上角坐标 和 长度
        for (len in limit downTo 1) { // 这个地方要在纸上画一下，才能更加清晰的掌握
            for (i in 0..m - len) {
                for (j in 0..n - len) {
                    // 判断第i/i + len - 1行中 j到j + len的位置子数组和是否为len
                    // 判断第j/j + len - 1列中 i到i + len的位置子数组和是否为len
                    if (preRowFix[i][j + len] - preRowFix[i][j] == len &&
                        preRowFix[i + len - 1][j + len] - preRowFix[i + len - 1][j] == len &&
                        preColFix[j][i + len] - preColFix[j][i] == len &&
                        preColFix[j + len - 1][i + len] - preColFix[j + len - 1][i] == len) {
                        return len * len
                    }
                }
            }
        }
        return 0
    }

}