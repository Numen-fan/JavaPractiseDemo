package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 12. 矩阵中的路径
 */
class Offer12 {

    private var flag: Array<IntArray>? = null

    fun exist(board: Array<CharArray>, word: String): Boolean {
        val m = board.size
        val n = board[0].size
        flag = Array(m) { IntArray(n) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (backTracking(board, i, j, word, 0)) {
                    return true
                }
            }
        }
        return false
    }

    /**
     * 判断上下左右是否满足接走走
     */
    private fun backTracking(board: Array<CharArray>, row: Int, col: Int, word: String, index: Int): Boolean {
        if (index == word.length) {
            return true // word遍历结束了
        }

        // 当前位置不满足
        if (row < 0 || row >= board.size || col < 0 || col >= board[0].size
            || flag!![row][col] == 1 ||  board[row][col] != word[index]) {
            return false
        }

        flag!![row][col] = 1 // 表示这个已经走过了
        // 表示当前位置满足，接着走其它三个方向，这里注意不能走回头路
        // 继续走下一个位置
        if (backTracking(board, row + 1, col, word, index + 1)) {
            return true
        }

        if (backTracking(board, row, col + 1, word, index + 1)) {
            return true
        }

        if (backTracking(board, row - 1, col, word, index + 1)) {
            return true
        }

        if (backTracking(board, row, col - 1, word, index + 1)) {
            return true
        }

        // 不满足，回溯
        flag!![row][col] = 0
        return false
    }

}