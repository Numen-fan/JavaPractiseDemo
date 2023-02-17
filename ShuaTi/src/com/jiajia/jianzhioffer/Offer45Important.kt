package com.jiajia.jianzhioffer

/**
 * 面试题45. 把数组排成最小的数
 */
class Offer45Important {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer45Important()
            println(o.minNumber(intArrayOf(121,12)))
        }
    }

    fun minNumber(nums: IntArray): String {
        val comparator = Comparator<String>{o1, o2 ->
            (o1 + o2).compareTo(o2 + o1)
        }
        val strs = nums.map { it.toString() }
        return strs.sortedWith(comparator).joinToString(separator = "")
    }

}