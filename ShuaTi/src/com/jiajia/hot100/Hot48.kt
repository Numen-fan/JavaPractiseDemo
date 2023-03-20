package com.jiajia.hot100

import com.jiajia.kit.ArrayUtils
import kotlin.math.max

class Hot48 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val h = Hot48()
            println(h.rotate(ArrayUtils.string2IntArray2("[[1,2],[3,4]]")))
        }
    }

    fun rotate(matrix: Array<IntArray>): Unit {
        ArrayUtils.print(matrix)
        println("--------------")
        val n = matrix.size
        if (n < 2) {
            return
        }

        // 一开始的旋转次数
        var cnt = n - 1
        // step用于控制从外到内第几层
        for (layer in 0 until n - 1) {
            var count = cnt
            while (count > 0) {
                var preNum = matrix[layer + 1][layer] // 第一步中[0][0]会替换的元素
                // 旋转上面的行
                for (col in layer until n - layer) {
                    val temp = matrix[layer][col]
                    matrix[layer][col] = preNum
                    preNum = temp
                }
                // 旋转右边的列
                for (row in layer + 1 until n - layer) {
                    val temp = matrix[row][n - layer - 1]
                    matrix[row][n - layer - 1] = preNum
                    preNum = temp
                }

                // 旋转下面的行
                for (col in n - layer - 2 downTo layer) {
                    val temp = matrix[n - layer - 1][col]
                    matrix[n - layer - 1][col] = preNum
                    preNum = temp
                }

                // 旋转左边的列
                for (row in n - layer - 2 downTo layer + 1) {
                    val temp = matrix[row][layer]
                    matrix[row][layer] = preNum
                    preNum = temp
                }
//                println("---------------")
                count--
            }
            // 里面层旋转少2两次
            cnt -= 2
        }
        ArrayUtils.print(matrix)
        return

    }

}