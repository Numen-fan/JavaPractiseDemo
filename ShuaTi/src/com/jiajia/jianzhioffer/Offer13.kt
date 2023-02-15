package com.jiajia.jianzhioffer

/**
 * 面试题13. 机器人的运动范围
 */
class Offer13 {

    var ans = 0

    private var flag:Array<IntArray>? = null

    fun movingCount(m: Int, n: Int, k: Int): Int {
        flag = Array(m) { IntArray(n) }
        backTracking(m, n, k, 0, 0)
       return ans
    }

    private fun backTracking(m: Int, n: Int, k: Int, row: Int, col: Int) {
        if (row == m || col == n || row < 0 || col < 0 || flag!![row][col] == 1) {
            return // 超出了宫格, 或者已经走过了，就不再继续走了
        }
        if (getSum(row) + getSum(col) > k) {
            return // 不能超过k
        }
        // 当前可以走到这个节点
        ans++
        flag!![row][col] = 1

        backTracking(m, n, k, row + 1, col)
        backTracking(m, n, k, row - 1, col)
        backTracking(m, n, k, row, col + 1)
        backTracking(m, n, k, row, col - 1)

        // 回溯, 这里不需要做回溯处理
        return
    }

    private fun getSum(num: Int): Int {
        var n = num
        var ans = 0
        while (n != 0) {
            ans += n % 10
            n /= 10
        }
        return ans
    }
}