package com.jiajia.jianzhioffer

import java.util.Deque
import java.util.LinkedList

/**
 * 剑指 Offer 30. 包含min函数的栈
 */
class Offer30 {

    companion object {

        class MinStack() {

            /** initialize your data structure here. */
            private val value: Deque<Int> = LinkedList()

            // 借助一个辅助栈存储最小元素
            private val minValue: Deque<Int> = LinkedList()

            init {
                minValue.push(Int.MAX_VALUE)
            }

            fun push(x: Int) {
                value.push(x)
                minValue.push(x.coerceAtMost(minValue.peek()))
            }

            fun pop() {
                value.pop()
                minValue.pop()
            }

            fun top(): Int {
                return value.peek()
            }

            fun min(): Int {
                return minValue.peek()
            }
        }

    }

}