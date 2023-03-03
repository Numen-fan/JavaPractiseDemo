package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 */
class Offer17 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer17()
            println(o.printNumbers(3).joinToString(separator = ","))
        }
    }

    fun printNumbers(n: Int): IntArray {
        val len = Math.pow(10.0, n.toDouble()).toInt()
        val ans = IntArray(len - 1)
        for (i in ans.indices) {
            ans[i] = i + 1
        }
        return ans
    }

}