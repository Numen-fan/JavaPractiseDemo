package com.jiajia.jingsai

import kotlin.test.assertNotSame
import kotlin.test.currentStackTrace

class Solution337 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution337()
            println(s.beautifulSubsets(intArrayOf(2,4,6), 2))
            println(s.findSmallestInteger(intArrayOf(3,0,3,2,4,2,1,1,0,4), 5))
        }
    }

    fun evenOddBit(n: Int): IntArray {
        val ans = IntArray(2)
        var num = n
        var index = 0
        while (num > 0) {
            if (num and 1 == 1 ) {
                ans[index % 2]++
            }
            num = num shr 1
            index++
        }
        return ans
    }

    /**
     * 6322. 检查骑士巡视方案
     */
    fun checkValidGrid(grid: Array<IntArray>): Boolean {
        if (grid[0][0] != 0) {
            return false
        }
        return checkCurPosition(grid, 0, 0)
    }

    /**
     * 校验当前点是否可以继续走下去
     */
    private fun checkCurPosition(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        if (grid[row][col] == grid.size * grid.size -1) {
            // 走到了终点，说明整体方案是有效的
            return true
        }

        // 判断当前点能否走下去
        val target = grid[row][col] + 1 // 下一个需要寻找到的目标

        // 判断8个方向
        // 1 最上面的两个
        if (row - 2 >= 0 && col - 1 >= 0 && grid[row - 2][col - 1] == target) {
            return checkCurPosition(grid, row - 2, col - 1)
        }
        if (row - 2 >= 0 && col + 1 < grid.size && grid[row - 2][col + 1] == target) {
            return checkCurPosition(grid, row - 2, col + 1)
        }
        // 最下面两个
        if (row + 2 < grid.size && col - 1 >= 0 && grid[row + 2][col - 1] == target) {
            return checkCurPosition(grid, row + 2, col - 1)
        }
        if (row + 2 < grid.size && col + 1 < grid.size && grid[row + 2][col + 1] == target) {
            return checkCurPosition(grid, row + 2, col + 1)
        }

        // 最左边的两个
        if (row - 1 >= 0 && col - 2 >= 0 && grid[row - 1][col - 2] == target) {
            return checkCurPosition(grid, row - 1, col - 2)
        }
        if (row + 1 < grid.size && col - 2 >= 0 && grid[row + 1][col - 2] == target) {
            return checkCurPosition(grid, row + 1, col - 2)
        }

        // 最右边的两个
        if (row - 1 >= 0 && col + 2 < grid.size && grid[row - 1][col + 2] == target) {
            return checkCurPosition(grid, row - 1, col + 2)
        }
        if (row + 1 < grid.size && col + 2 < grid.size && grid[row + 1][col + 2] == target) {
            return checkCurPosition(grid, row + 1, col + 2)
        }
        return false
    }

    /**
     * 6352. 美丽子集的数目
     */

    val path = ArrayList<Int>()
    var ans = 0
    fun beautifulSubsets(nums: IntArray, k: Int): Int {
        backTracking(nums, 0, k)
        return ans
    }

    private fun backTracking(nums: IntArray, curIndex: Int, k: Int) {
        if (path.isNotEmpty()) {
            ans++ // 一个合理的子集
        }
        if (curIndex >= nums.size) {
            return
        }
        for (i in curIndex until nums.size) {
            // 判断第i个元素是否可以加入到path中
            if (path.contains(nums[i] - k) || path.contains(nums[i] + k)) {
                continue
            }
            // nums[i] 满足
            path.add(nums[i])
            backTracking(nums, i + 1, k)
            // 回溯
            path.removeAt(path.size - 1)
        }
    }

    /**
     * 6321. 执行操作后的最大 MEX
     */
    fun findSmallestInteger(nums: IntArray, value: Int): Int {
        var mex = 0
        while (true) {
            nums.sort()
            if (nums[nums.size - 1] == 0 && value == 1) {
                return nums.size
            }
            if (nums.contains(mex)) {
                // 只保留一个mex, 将剩余的mex都 + value
                var index = nums.indexOf(mex) + 1
                while (index < nums.size && nums[index] == mex) {
                    nums[index] += value
                    index++
                }
                mex++
                continue
            }
            // nums中没有mex, 接下来试着去寻找mex
            // 找到了就继续mex+1
            // 找不到就返回mex
            var find = false
            for (i in nums.indices) {
                if (nums[i] in 1 until mex) { // 小于mex的不动
                    continue
                }

                if (nums[i] < 0 && (mex - nums[i]) % value == 0) {
                    nums[i] = mex
                    mex++
                    find = true
                    break
                } else if (nums[i] > 0 && (nums[i] - mex) % value == 0) {
                    nums[i] = mex
                    mex++
                    find = true
                    break
                }
            }
            if (!find) {
                return mex
            }
        }
    }
}