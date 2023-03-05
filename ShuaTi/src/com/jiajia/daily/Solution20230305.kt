package com.jiajia.daily

import kotlin.math.max

/**
 * 1599. 经营摩天轮的最大利润
 */
class Solution20230305 {




    fun minOperationsMaxProfit(customers: IntArray, boardingCost: Int, runningCost: Int): Int {
        var cnt = -1
        var wait = 0 // 当前等待人数
        var mx = 0 // 最大利润
        var i = 0 // 转动次数
        var t = 0 // 利润
        while (wait > 0 || i < customers.size) {
            wait += if(i < customers.size) customers[i] else 0 // 第i次轮转时，等待的总人数
            val upNum = wait.coerceAtMost(4) // 最多上4个人
            wait -= upNum // 等待人数减去上去的人数
            // 计算利润
            t += upNum * boardingCost - runningCost
            i++ // 这里先加1了，如果是0，那么i = 1,表示一次轮转
            if (t > mx) {
                mx = t
                cnt = i
            }
        }
        return cnt
    }
}