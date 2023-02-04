package com.jiajia.daily

/**
 * 2325. 解密消息
 */
class Solution20230201 {

    fun decodeMessage(key: String, message: String): String {
        var map: MutableMap<Char, Char> = HashMap()
        var i = 0

        for (c in key.toCharArray()) {
            if (map.containsKey(c) || c == ' ') {
                continue
            }
            map[c] = 'a'.plus(i)
            i++
        }

        var chs = message.toCharArray()

        for (i in chs.indices) {
            if (chs[i] == ' ') {
                continue
            }
            chs[i] = map[chs[i]]!!
        }
        return String(chs)
    }
}