package com.jiajia.hot100

class Hot64 {

    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(m) { IntArray(n) }
        dp[0][0] = grid[0][0]
        for (row in 1 until m) {
            dp[row][0] = dp[row - 1][0] + grid[row][0]
        }
        for (col in 1 until n) {
            dp[0][col] = dp[0][col - 1] + grid[0][col]
        }

        for (row in 1 until m) {
            for (col in 1 until n) {
                dp[row][col] = dp[row - 1][col].coerceAtMost(dp[row][col - 1]) + grid[row][col]
            }
        }

        return dp[m - 1][n - 1]
    }

}