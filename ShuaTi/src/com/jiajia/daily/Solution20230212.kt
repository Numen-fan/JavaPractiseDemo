package com.jiajia.daily

import kotlin.math.abs

class Solution20230212 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230212()
            println(s.alphabetBoardPath("zdz"))
        }
    }

    fun alphabetBoardPath(target: String): String {
        val sb = java.lang.StringBuilder()
        var curPosition = intArrayOf(0, 0)
        for (i in target.indices) {
            val nextPosition = getPosition(target[i])
            sb.append(getPath(curPosition, nextPosition))
            curPosition = nextPosition
        }
        return sb.toString()
    }

    private fun getPosition(c: Char):IntArray {
        val a = c - 'a'
        val ans = IntArray(2)
        ans[0] = a / 5 // 第几行
        ans[1] = a % 5 // 第几列
        return ans
    }

    private fun getPath(curPosition: IntArray, nextPoint: IntArray): String {
        val sb = java.lang.StringBuilder()

        if (nextPoint[0] == 5) { // 下一个在z
            // 优先走列
            sb.append(getColPath(curPosition, nextPoint))
            sb.append(getRowPath(curPosition, nextPoint))
        } else {
            // 默认优先走行
            sb.append(getRowPath(curPosition, nextPoint))
            sb.append(getColPath(curPosition, nextPoint))
        }
        sb.append('!')
        return sb.toString()
    }

    private fun getRowPath(curPosition: IntArray, nextPoint: IntArray): String {
        val sb = java.lang.StringBuilder()
        // 优先走行
        // 如果在同一行，则走左右
        // 如果在上面，走U
        // 如果在下面，走D
        val curRow = curPosition[0]
        val nextRow = nextPoint[0]
        if (curRow != nextRow) {
            val diffRowCnt = Math.abs(curRow - nextRow)
            val ch = if (curRow < nextRow) 'D' else 'U'
            for (i in 0 until diffRowCnt) {
                sb.append(ch)
            }
        }
        return sb.toString()
    }

    private fun getColPath(curPosition: IntArray, nextPoint: IntArray): String {
        val sb = java.lang.StringBuilder()
        val curCol = curPosition[1]
        val nextCol = nextPoint[1]
        if (curCol != nextCol) {
            val diffColCnt = Math.abs(curCol - nextCol)
            val ch = if (curCol < nextCol) 'R' else 'L'
            for (i in 0 until diffColCnt) {
                sb.append(ch)
            }
        }
        return sb.toString()
    }

}