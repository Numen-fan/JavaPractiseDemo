package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 16. 数值的整数次方
 */
class Offer16Important {

    fun myPow(x: Double, n: Int): Double {
        return if (n < 0) 1.0 / method(x, -n) else method(x, n)
    }

    private fun method(x: Double, n: Int): Double {
        if (n == 0) {
            return 1.0
        }
        val y = method(x, n / 2) // 【这就是优化点啊】
        return if (n % 2 == 0) y * y else x * y * y
    }

}