package com.jiajia.daily

import java.util.*
import kotlin.collections.ArrayList

/**
 * 2363. 合并相似的物品
 */
class Solution20230228 {

    fun mergeSimilarItems(items1: Array<IntArray>, items2: Array<IntArray>): List<List<Int>> {
        val map = TreeMap<Int, Int>()
        for (item in items1.plus(items2)) {
            val weight = map.getOrDefault(item[0], 0)
            map[item[0]] =  weight + item[1]
        }
        val list = ArrayList<List<Int>>(map.size)
        for ((k, v) in map) {
            list.add(listOf(k, v))
        }
        return list
    }
}