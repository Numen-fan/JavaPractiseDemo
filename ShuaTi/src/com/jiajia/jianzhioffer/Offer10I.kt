package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 10- I. 斐波那契数列
 */
class Offer10I {

    private val mod = 1000000007

    fun fib(n: Int): Int {
        if (n < 2) {
            return n
        }
//        return fib(n - 1) % mod + fib(n - 2) % mod // 递归会超时
        var ans = 1
        var p: Int
        var q = 0
        for (i in 2..n) {
            p = q
            q = ans
            ans = (p + q) % mod
        }
        return ans
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer10I()
            println(o.fib(5))
        }
    }

}