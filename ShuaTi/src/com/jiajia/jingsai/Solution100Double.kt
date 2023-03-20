package com.jiajia.jingsai

import java.util.Collections
import java.util.PriorityQueue

class Solution100Double {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution100Double()
            println(s.distMoney(24, 11))
            println(s.maximizeGreatness(intArrayOf(1,2,3,4)))
            println(s.findScore(intArrayOf(2,5,6,6,10)))
        }
    }
    /**
     * 6323. 将钱分给最多的儿童
     * https://leetcode.cn/contest/biweekly-contest-100/problems/distribute-money-to-maximum-children/
     */
    fun distMoney(money: Int, children: Int): Int {
        var ans = -1
        if (money < children) { // 不可能有孩子能分配8元
            return ans
        }

        if ((money - 8) / (children - 1) < 1) {
            return 0 // 给一个人分配8之后，其余不满足了
        }

        // 那说明一定有满足的孩子能分配到8
        ans = money / 8
        var lastChild = children - ans
        var lastMoney = money % 8 // 剩余的钱
        if (lastChild <= 0) {
            return if (children * 8 < money) children - 1 else children
        }
        while (lastMoney < lastChild) {
            lastMoney += 8
            lastChild++
            ans--
        }
        return if(lastMoney == 4 && lastChild == 1 || lastMoney > 0 && lastChild == 0) ans - 1 else ans
    }

    /**
     * 6324. 最大化数组的伟大值
     */
    fun maximizeGreatness(nums: IntArray): Int {
        var ans = 0
        val copyNums = ArrayList(nums.toList())
        copyNums.sort() // 从小到大排列了
        for (num in nums) {
            if (num >= copyNums[copyNums.size - 1]) {
                continue
            }
            if (getNum(copyNums, num) != -1) {
                ans++
            }
        }
        return ans

    }

    private fun getNum(nums: ArrayList<Int>, target:Int): Int {
        var index = -1
        var value = Int.MAX_VALUE
        var mid = nums.size / 2
        var start = 0
        var end = nums.size
        if (nums[mid] <= target) {
            start = mid
        } else {
            end = mid + 1
        }

        mid = (start + end) /  2
        if (nums[mid] <= target) {
            start = mid
        } else {
            end = mid + 1
        }

        for (i in start until end) {
            if (nums[i] in (target + 1) until value) {
                index = i
                value = nums[i]
                break
            }
        }
        return if (index == -1) {
            -1
        } else {
            nums.removeAt(index)
            value
        }
    }

    /**
     * 6351. 标记所有元素后数组的分数
     */
    fun findScore(nums: IntArray): Long {
        var ans = 0L
        val len = nums.size
        var cnt = 0
        val queue = PriorityQueue<IntArray> { o1, o2 -> if (o1[0] == o2[0]) o1[1] - o2[1] else o1[0] - o2[0] }
        for (i in nums.indices) {
            queue.add(intArrayOf(nums[i], i))
        }

        while (cnt < len) {
            val (num, index) = queue.poll()
            if (nums[index] == 0) {
                continue
            }

            ans += num
            nums[index] = 0
            cnt++
            if (index > 0 && nums[index - 1] > 0) {
                nums[index - 1] = 0
                cnt++
            }
            if (index + 1 < nums.size && nums[index + 1] > 0) {
                nums[index + 1] = 0
                cnt++
            }
        }

        return ans
    }

}