package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 40. 最小的k个数
 */
class Offer40 {

    fun getLeastNumbers(arr: IntArray, k: Int): IntArray {
        arr.sort()
        return arr.copyOfRange(0, k)
    }

}