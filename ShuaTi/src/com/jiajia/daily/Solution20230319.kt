package com.jiajia.daily

class Solution20230319 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230319()
            println(s.findLexSmallestString("43987654", 7, 3))
        }
    }

    val list = ArrayList<String>()
    lateinit var min: String
    fun findLexSmallestString(s: String, a: Int, b: Int): String {
        min = s
        find(s, a, b)
        return min
    }

    private fun find(s: String, a: Int, b: Int) {
        // 递归结束条件是什么
        if (list.contains(s)) { // s已经出现轮回了
            return
        }
        list.add(s)

        // 先累加
        val chs = s.toCharArray()
        for (i in chs.indices) {
            if (i % 2 == 1) {
                chs[i] ='0'.plus((chs[i] - '0' + a) % 10)
            }
        }
        var ts = String(chs)
        min = min.coerceAtMost(ts)
        find(ts, a, b)

        // 轮转
        ts = s.substring(b) + s.substring(0, b)
        min = min.coerceAtMost(ts)
        find(ts, a, b)
    }
}