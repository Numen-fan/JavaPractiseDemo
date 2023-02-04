package com.jiajia.daily

import java.util.*

/**
 * 1798. 你能构造出连续值的最大数目
 */
class Solution20230204 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
    }

    fun getMaximumConsecutive(coins: IntArray): Int {
        var ans = 1
        Arrays.sort(coins)
        for (i in coins) {
            if (i > ans) {
                break
            }
            ans += i
        }
        return ans
    }


}