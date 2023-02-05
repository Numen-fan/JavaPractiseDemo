package com.jiajia.jingsai

class Solution331Kotlin {

    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray? {
        val ans = IntArray(queries.size)
        val list: List<Char> = mutableListOf('a', 'e', 'i', 'o', 'u')
        val map: MutableMap<Int, Boolean> = HashMap()
        for ((index, query) in queries.withIndex()) {
            for (i in query[0]..query[1]) {
                if (map.containsKey(i)) { // 如果这个单词已经被判断过了
                    if (map[i]!!) { // 有效的单词
                        ans[index]++
                    }
                    continue
                }
                val word = words[i]
                if (list.contains(word[0]) && list.contains(word[word.length - 1])) {
                    map[i] = true
                    ans[index]++
                } else {
                    map[i] = false
                }
            }
        }
        return ans
    }

}