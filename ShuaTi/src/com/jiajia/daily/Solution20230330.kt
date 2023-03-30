package com.jiajia.daily

class Solution20230330 {

    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        points.sortWith(comparator =  Comparator(){ o1, o2 -> o1[0] - o2[1] })
        var ans = 0
        for (i in 1 until points.size) {
            ans = ans.coerceAtLeast(points[i][0] - points[i - 1][0])
        }
        return ans
    }

}