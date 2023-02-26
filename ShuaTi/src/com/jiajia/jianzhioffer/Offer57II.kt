package com.jiajia.jianzhioffer

import com.jiajia.kit.ArrayUtils

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 */
class Offer57II {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer57II()
            ArrayUtils.print(o.findContinuousSequence(15))
        }
    }

    fun findContinuousSequence(target: Int): Array<IntArray> {
        val vec = ArrayList<IntArray>()
        for (i in 1..target / 2) { // 遍历所有的起点
            var sum = 0
            for (j in i until target) {
                sum += j
                if (sum > target) {
                    sum = 0
                    break
                } else if (sum == target) {
                    sum = 0
                    val arr = IntArray(j - i + 1)
                    for (k in 0 until j - i + 1) {
                        arr[k] = i + k
                    }
                    vec.add(arr)
                    break
                }
            }
        }
        return vec.toTypedArray()
    }

}