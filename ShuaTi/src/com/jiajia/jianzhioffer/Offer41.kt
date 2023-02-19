package com.jiajia.jianzhioffer

import java.util.PriorityQueue
import kotlin.math.min

/**
 * 剑指 Offer 41. 数据流中的中位数
 */
class Offer41 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer41()
            o.addNum(1)
            o.addNum(2)
            o.addNum(3)
            println(o.findMedian())
        }
    }

    val queue = ArrayList<Int>()

    private var minQueue: PriorityQueue<Int> = PriorityQueue<Int> { o1, o2 -> o2 - o1 }
    private var maxQueue: PriorityQueue<Int> = PriorityQueue<Int>()

    fun addNum(num: Int) {
        if (minQueue.isEmpty() || num <= minQueue.peek()) { // minQueue中最大的元素比添加的元素小
            minQueue.offer(num)
            // 需要转移minQueue中的元素到maxQueue中
            if (minQueue.size - maxQueue.size > 1) {
                maxQueue.offer(minQueue.poll())
            }

        } else {
            maxQueue.offer(num)
            // 需要转移maxQueue中的元素到minQueue中
            if (maxQueue.size > minQueue.size) {
                minQueue.offer(maxQueue.poll())
            }
        }
    }

    fun findMedian(): Double {
        return if (minQueue.size > maxQueue.size) {
            minQueue.peek().toDouble()
        } else {
            (minQueue.peek() + maxQueue.peek()) / 2.0
        }
    }

    /**
     * 这种暴力方法，能过，但是性能很差
     */
    private fun method(): Double {
        val size = queue.size
        queue.sort()
        return if (size % 2 == 0) {
            ((queue[size / 2 - 1] + queue[size / 2]) / 2.0)
        } else {
            queue[size / 2].toDouble()
        }
    }



}