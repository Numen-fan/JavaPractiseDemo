package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solutions/210882/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
 */
class Offer65Important {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer65Important()
            println(o.add(1,1))
        }
    }

    fun add(a: Int, b: Int): Int {
        var ta = a
        var tb = b
        while (tb != 0) {
            val c = (ta and tb) shl 1
            ta = ta xor tb
            tb = c
        }
        return ta
    }

}