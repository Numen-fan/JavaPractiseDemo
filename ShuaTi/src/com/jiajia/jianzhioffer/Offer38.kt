package com.jiajia.jianzhioffer

class Offer38 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer38()
            println(o.permutation("abc").joinToString(","))
        }
    }

    private val ans = ArrayList<String>()

    fun permutation(s: String): Array<String> {
        backTracking(s, java.lang.StringBuilder(), IntArray(s.length))
        return ans.toTypedArray()
    }

    private fun backTracking(s: String, sb: StringBuilder, flag: IntArray) {
        // 递归结束条件
        if (sb.length == s.length) {
            if (!ans.contains(sb.toString())) {
                ans.add(sb.toString())
            }
            return
        }


        // 选择本层节点
        for (i in s.indices) {
            // 已经被选择的不能再被选择
            if (flag[i] == 1) {
                continue
            }
            // 选择s[i]
            sb.append(s[i])
            flag[i] = 1
            backTracking(s, sb, flag)
            // 回溯
            sb.delete(sb.length - 1, sb.length)
            flag[i] = 0
        }
    }
}