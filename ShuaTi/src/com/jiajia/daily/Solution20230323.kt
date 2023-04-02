package com.jiajia.daily

class Solution20230323 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230323()
            s.checkArithmeticSubarrays(intArrayOf(4,6,5,9,3,7), intArrayOf(0,0,2), intArrayOf(2,3,5))
        }
    }

    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val ans = ArrayList<Boolean>(l.size)
        // 可能得做缓存,否则可能会超时
        for (i in l.indices) {
            ans.add(valid(nums, l[i], r[i]))
        }
        return ans

    }

    private fun valid(nums: IntArray, l: Int, r: Int): Boolean {
        if (r - l < 1) {
            return false
        }
        val arr = nums.copyOfRange(l, r + 1)
        arr.sort()
        val step = arr[1] - arr[0]
        for (i in 2 until arr.size) {
            if (arr[i] - arr[i - 1] != step) {
                return false
            }
        }
        return true
    }
}