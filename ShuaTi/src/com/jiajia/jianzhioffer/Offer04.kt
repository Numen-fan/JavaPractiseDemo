package com.jiajia.jianzhioffer

class Offer04 {

    fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == target) {
                    return true
                }
            }
        }
        return false
    }
}