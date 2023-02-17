package com.jiajia.jianzhioffer

class Offer61 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer61()
            println(o.isStraight(intArrayOf(0,0,1,2,5)))
        }
    }

    fun isStraight(nums: IntArray): Boolean {
        val arr = IntArray(5) // 必须是5张牌
        nums.sort() // 排序
        var zeroCnt = nums.lastIndexOf(0) + 1 // 0的数量
        val minNum = nums[zeroCnt] // 除开0以外的最小数
        for (i in zeroCnt until nums.size) {
            if (nums[i] - minNum >= 5) {
                return false
            }
            arr[nums[i] - minNum]++
        }

        // 有0，这个时候就需要特殊处理了
        if (zeroCnt > 0) {
            for (i in arr.indices) {
                if (arr[i] == 0 && zeroCnt > 0) {
                    arr[i] = 1
                    zeroCnt--
                }
            }
        }
        return arr.none { it != 1 } // 不存在不为1的数
    }
}