package com.jiajia.jianzhioffer

import com.jiajia.kit.ArrayUtils

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 */
class Offer29 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Offer29()
            ArrayUtils.print(s.spiralOrder(ArrayUtils.string2IntArray2("[[1,2,3],[4,5,6],[7,8,9]]")))
        }
    }

    fun spiralOrder(matrix: Array<IntArray>): IntArray {
        if (matrix.isEmpty()) {
            return intArrayOf()
        }
        val row = matrix.size
        val col = matrix[0].size
        val ans = IntArray(row * col)
        var index = 0
        // 打印的上下左右边界
        var top = 0
        var left = 0
        var right = col - 1
        var bottom = row - 1
        var cnt = 0  // 打印次数
        while (true) {
            // 向右边打印, 列的边界为right
            for (k in left .. right) {
                ans[index++] = matrix[top][k]
                cnt++
            }
            if (cnt == row * col) {
                break
            }
            // 需要修改上边界
            top++
            // 向下打印, 行的边界为bottom
            for (k in top.. bottom) {
                ans[index++] = matrix[k][right]
                cnt++
            }
            if (cnt == row * col) {
                break
            }
            // 修改右边边界
            right--

            // 向左边打印，列的边界为left
            for (k in right downTo  left) {
                ans[index++] = matrix[bottom][k]
                cnt++
            }
            if (cnt == row * col) {
                break
            }
            // 修改下边缘
            bottom--

            // 向上打印，行的边界为top
            for (k in bottom downTo top) {
                ans[index++] = matrix[k][left]
                cnt++
            }
            if (cnt == row * col) {
                break
            }
            // 修改左边界
            left++
        }
        return ans
    }

}