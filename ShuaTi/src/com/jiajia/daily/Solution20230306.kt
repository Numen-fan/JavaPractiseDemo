package com.jiajia.daily

/**
 * 1653. 使字符串平衡的最少删除次数
 */
class Solution20230306 {
    /**
     * a全部出现在左边，b全部出现在右边，那么就存在一个分割线，满足这个情况
     * 所以枚举所有的分割线，计算左边b的数量 + 右边a的数量，二者和就是需要删除的次数
     * 返回所有分割线处的最小值，即为答案
     */
    fun minimumDeletions(s: String): Int {
        val arr = s.toCharArray()
        var del = 0
        for (ch in arr) {
            del += 'b' - ch // 累加a字符的数量
        }

        var ans = del
        for (ch in arr) { // 开始分割
            del += (ch - 'a') * 2 - 1 // 这个地方最好结合具体的例子推到一下
            ans = ans.coerceAtMost(del)
        }
        return ans
    }
}