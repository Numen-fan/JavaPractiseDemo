package com.jiajia.daily

import java.util.PriorityQueue

/**
 * 2335. 装满杯子需要的最短总时长
 */
class Solution20230211 {

    fun fillCups(amount: IntArray): Int {
        val queue = PriorityQueue<Int>(3) { o1, o2 -> o2 - o1 }
        queue.addAll(amount.asList())
        var ans = 0
        while (queue.peek() > 0) {
            ans++
            var first = queue.poll()
            var second = queue.poll()
            queue.add(first - 1)
            queue.add(second - 1)
        }
        return ans
    }


}