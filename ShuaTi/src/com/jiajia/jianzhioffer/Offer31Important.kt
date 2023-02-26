package com.jiajia.jianzhioffer

import java.util.LinkedList

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 */
class Offer31Important {

    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        // 边压，边出，最后看桟是否为空
        val stack = LinkedList<Int>()
        var j = 0 // 索引出栈
        for (num in pushed) {
            stack.push(num) // 压栈
            // 判断当前的出栈序列
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                // 出栈
                stack.poll()
                j++ // 继续下一个
            }
        }
        return stack.isEmpty()
    }

}