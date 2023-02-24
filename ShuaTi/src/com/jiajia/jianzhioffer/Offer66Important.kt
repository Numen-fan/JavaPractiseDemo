package com.jiajia.jianzhioffer

class Offer66Important {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer66Important()
            println(o.method(intArrayOf(1,2,3,4,5)))
        }
    }

    fun constructArr(a: IntArray): IntArray {
        if (a.isEmpty()) {
            return a
        }
        val b = IntArray(a.size)
        b[0] = method(a, 0)
        for (i in 1 until a.size) {
            if (a[i] == 0) {
                b[i] = method(a, i)
            } else {
                b[i] = b[i - 1] * a[i - 1] / a[i]
            }
        }
        return b
    }

    private fun method(nums: IntArray, k: Int): Int {
        var t = 1
        for (i in  nums.indices) {
            if (i == k) {
                continue
            }
            t *= nums[i]
        }
        return t
    }

    private fun method(nums: IntArray): IntArray {
        val ans = IntArray(nums.size)
        var pre = nums[0]
        ans[0] = 1
        for (i in 1 until nums.size) { // 从左往右，不包括自己
            ans[i] = pre
            pre *= nums[i]
        }

        pre = nums[nums.size - 1]
        for (i in nums.size - 2 downTo 0) {
            ans[i] *= pre
            pre *= nums[i]
        }

        return ans
    }
}