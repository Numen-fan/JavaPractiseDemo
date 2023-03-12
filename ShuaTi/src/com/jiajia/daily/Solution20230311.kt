package com.jiajia.daily

class Solution20230311 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230311()
            println(s.findLongestSubarray(arrayOf("A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M")).contentToString())
        }
    }

    fun findLongestSubarray(array: Array<String>): Array<String> {
        val len = array.size
        val preSumChar = IntArray(len + 1)
        val preSumNum = IntArray(len + 1)
        for (i in array.indices) {
            preSumChar[i + 1] = preSumChar[i] + if (Character.isDigit(array[i][0])) 0 else 1 // 字母
            preSumNum[i + 1] = preSumNum[i] + if (Character.isDigit(array[i][0])) 1 else 0 // 数字
        }

        var left = 0
        var right = 0
        var max = 0

        for (i in 0 until  len - 1) {
            // 这里应该可以剪枝
            if (len - i <= max) {
                break // 剩下的区间已经不可能满足了
            }
            for (j in i + 1 until len) {
                if (preSumNum[j + 1] - preSumNum[i] == preSumChar[j + 1] - preSumChar[i]) {
                    // i~j这个区间满足了
                    val l = j - i + 1
                    if (l > max) {
                        max = l
                        left = i
                        right = j
                    }
                }
            }
        }

        if (max == 0) {
            return arrayOf()
        }

        return if (max == len) {
            array
        } else {
            array.copyOfRange(left, right + 1)
        }
    }

}