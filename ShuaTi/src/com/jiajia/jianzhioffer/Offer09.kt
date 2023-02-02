package com.jiajia.jianzhioffer

import java.util.Stack

/**
 * 剑指 Offer 09. 用两个栈实现队列
 */
class Offer09 {

    companion object {
        class CQueue {

            private val stack1: Stack<Int> = Stack()

            private val stack2: Stack<Int> = Stack()
            fun appendTail(value: Int) {
                stack1.push(value)
            }

            fun deleteHead(): Int {
                if (stack1.empty()) {
                    return -1
                }
                while (!stack1.empty()) {
                    stack2.push(stack1.pop())
                }
                val ans = stack2.pop()
                while (!stack2.empty()) {
                    stack1.push(stack2.pop())
                }
                return ans;
            }

        }
    }

}