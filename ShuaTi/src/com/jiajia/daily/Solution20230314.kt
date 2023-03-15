package com.jiajia.daily

class Solution20230314 {

    /**
     * 1605. 给定行和列的和求可行矩阵
     */
    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
        val row = rowSum.size
        val col = colSum.size
        val ans = Array(row) { IntArray(col) }

        // 对每个ans[i][j]，直接赋值min(rowSum[i], colSum[j]), 然后rowSum[i]和rowSum[j] - ans[i][j]
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (rowSum[i] == 0 && colSum[j] == 0) {
                    continue
                }
                ans[i][j] = rowSum[i].coerceAtMost(colSum[j])
                rowSum[i] -= ans[i][j]
                colSum[j] -= ans[i][j]
            }
        }
        return ans
    }

}