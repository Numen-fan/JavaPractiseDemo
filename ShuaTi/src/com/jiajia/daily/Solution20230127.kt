package com.jiajia.daily

class Solution20230127 {

    fun greatestLetter(s: String): String {
        val arr = IntArray(26)
        for (c in s.toCharArray()) {
            var diff = c - 'a'
            if (diff in 0..25 && arr[diff] != 3) {
                // 小写
                arr[diff] = if (arr[diff] == 2) 3 else 1
            }

            diff = c - 'A'
            if (diff in 0..25 && arr[diff] != 3) {
                // 大写
                arr[diff] = if (arr[diff] == 1) 3 else 2
            }
        }

        for (i in 25 downTo 0) {
            if (arr[i] == 3) {
                return ('A' + i).toString()
            }
        }
        return ""
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230127()
            println(s.greatestLetter("arRAzFif"))
        }
    }
}