package com.jiajia.jianzhioffer

class Offer50 {

    fun firstUniqChar(s: String): Char {
        val cnt = IntArray(26)
        for (c in s.toCharArray()) {
            cnt[c - 'a']++
        }

        var minIndex = Int.MAX_VALUE
        for (i in cnt.indices) {
            if (cnt[i] == 1) {
                var c = 'a'.plus(i)
                minIndex = s.indexOf(c).coerceAtMost(minIndex)
            }
        }
        if (minIndex == Int.MAX_VALUE) {
            return ' '
        } else {
            return s[minIndex]
        }
    }
}