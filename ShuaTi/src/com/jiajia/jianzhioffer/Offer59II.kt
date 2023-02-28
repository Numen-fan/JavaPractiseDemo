package com.jiajia.jianzhioffer

import java.util.ArrayDeque
import java.util.LinkedList
import java.util.Stack

/**
 * 面试题59 - II. 队列的最大值
 */
class Offer59II {

    // 最大值维护
    private val stack = Stack<Int>()

    // 数据维护
    private val queue = LinkedList<Int>()

    fun max_value(): Int {
        if (queue.isEmpty()) {
            return -1
        }
        // 取栈底元素
        // 需要更新最大值栈，需要把栈底的元素弹出
        val tStack = Stack<Int>()
        while (!stack.isEmpty()) {
            tStack.push(stack.pop())
        }
        val ans= tStack.peek() // 当前最大值弹出
        while (!tStack.isEmpty()) {
            stack.push(tStack.pop())
        }
        return ans
    }

    fun push_back(value: Int) {
        queue.add(value)
        // 更新最大值
        var cnt = 0
        while (!stack.isEmpty() && stack.peek() < value) { // 将前面小于value的最大值，全部出栈，并记录每个元素对应的最大值
            stack.pop()
            cnt++
        }
        for (i in 0 until cnt) {
            stack.push(value)
        }
        stack.push(value) // 当前元素作为队中唯一元素时，一定会加入其中
    }

    fun pop_front(): Int {
        if (queue.isEmpty()) {
            return -1
        }

        // 需要更新最大值栈，需要把栈底的元素弹出
        val tStack = Stack<Int>()
        while (!stack.isEmpty()) {
            tStack.push(stack.pop())
        }
        tStack.pop() // 当前最大值弹出
        while (!tStack.isEmpty()) {
            stack.push(tStack.pop())
        }
        return queue.poll()

    }

}