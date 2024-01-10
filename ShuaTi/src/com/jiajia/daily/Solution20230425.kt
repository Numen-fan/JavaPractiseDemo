package com.jiajia.daily

class Solution20230425 {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        val n = names.size
        var ans = Array(n) { "" }
        val arr = Array(n) { IntArray(2) }
        for (i in names.indices) {
            arr[i] = intArrayOf(i, heights[i])
        }
        arr.sortWith(comparator = Comparator() {o1,o2 -> o2[1] - o1[1]})
        for (i in names.indices) {
            ans[i] = names[arr[i][0]]
        }
        return ans
    }
}