package com.jiajia.hot100

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

/**
 * 22. 括号生成
 */
class Hot22 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val h = Hot22()
            println(h.generateParenthesis(3 * 2).joinToString(separator = ","))
        }
    }

    val list = ArrayList<String>()
    var sb = StringBuilder()

    fun generateParenthesis(n: Int): List<String> {
        backTracking(n)
        return list
    }

    private fun backTracking(n: Int) {
        if (sb.length == n) {
            if (match(sb.toString())) {
                // 一个合法的括号对诞生了
                list.add(sb.toString())
            }
            return
        }
        // 如果前面是空或者）则可以拼接（
        if (sb.isEmpty()) {
            // 确保第一个是（ 做到一个剪枝的效果
            sb.append('(')
            backTracking(n)
        } else {
            // 这种情况不只有）。也可以是（
            sb.append("(")
            backTracking(n)
            // 回溯
            sb.deleteCharAt(sb.length - 1)
            sb.append(")")
            backTracking(n)
            sb.deleteCharAt(sb.length - 1)
        }
    }

    private fun match(string: String): Boolean {
        val stack = Stack<Char>()
        var index = 0
        while (index < string.length) {
            val c = string[index]
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() == ')') {
                    return false
                } else {
                    stack.pop()
                }
            } else {
                stack.push(string[index])
            }
            index++
        }
        return stack.isEmpty()
    }
}