package com.jiajia.jianzhioffer

import java.util.*

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 */
class Offer11 {

    fun minArray(numbers: IntArray?): Int {
        return Arrays.stream(numbers).min().asInt
    }

}