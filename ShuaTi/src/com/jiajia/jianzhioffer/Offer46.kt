package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=b3nqjxj
 */
class Offer46 {

    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length < 2) {
            return s.length
        }
        var ans = 1
        val list = ArrayList<Char>()
        list.add(s[0])
        for (i in 1 until s.length) {
            val index = list.indexOf(s[i])
            if (index != -1) {
                ans = ans.coerceAtLeast(list.size)
//                list.clear() // 这里不能直接清空，得看s[i]出现的位置
                for (j in 0..index) {
                    list.removeAt(0) // 注意这里，一直移除第一个就好了，其实这里可以用队列，比较好
                }
            }
            list.add(s[i])
        }
        // 注意最后list可能还有内容的
        return ans.coerceAtLeast(list.size)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer46()
            print(o.lengthOfLongestSubstring("dvdf"))
        }
    }
}