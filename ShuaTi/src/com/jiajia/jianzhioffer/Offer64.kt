package com.jiajia.jianzhioffer

class Offer64 {

    fun sumNums(n: Int): Int {
        if (n < 2) {
            return n
        }
        return sumNums(n - 1) + n
    }

}