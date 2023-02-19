package com.jiajia.daily

import java.util.Arrays

/**
 * 1237. 找出给定方程的正整数解
 */
class Solution20230218 {
    fun findSolution(customfunction:CustomFunction, z:Int):List<List<Int>> {
        val ans = ArrayList<List<Int>>()
        for (i in 1..1000) {
            for (j in 1 ..1000) {
                if (customfunction.f(i, j) == z) {
                    ans.add(listOf(i, j))
                    break
                }
            }
        }
        return ans
    }

    class CustomFunction {
        fun f(x: Int, y: Int): Int {
            return  0
        }
    }
}