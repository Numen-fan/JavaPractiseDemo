package com.jiajia.daily

class Solution20230325 {

    fun findLengthOfShortestSubarray(arr: IntArray): Int {
        val len = arr.size
        var j = len - 1
        while (j > 0 && arr[j] >= arr[j - 1]) {
            j--
        }
        if (j <= 0) {
            return 0 // 原始序列是有序的
        }

        var ans = j
        for (i in arr.indices) { // 删除i + 1到j - 1这一段
            while (j < len && arr[j] < arr[i]) {
                j++
            }
            ans = ans.coerceAtMost(j - i - 1)
            if (i + 1 < len && arr[i] > arr[i + 1]) {
                break
            }
        }
        return ans
    }

}