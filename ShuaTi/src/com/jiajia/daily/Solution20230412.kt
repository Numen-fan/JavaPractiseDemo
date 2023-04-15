package com.jiajia.daily

class Solution20230412 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230412()
            println(s.mostFrequentEven(intArrayOf(0,1,2,2,4,4,1)))
        }
    }

    fun mostFrequentEven(nums: IntArray): Int {
        nums.sort()
        var ans = -1
        var cnt = 0
        var tpCnt = 0
        var lastNum = -1
        for (i in nums.indices) {
            if (nums[i] % 2 != 0) { // 如果是奇数
                if (lastNum != -1 && tpCnt > cnt) {
                    ans = lastNum;
                    cnt = tpCnt
                }
                tpCnt = 0
                continue
            }
            // 偶数
            if (nums[i] != lastNum) {
                // 新的偶数
                if(lastNum != -1 && tpCnt > cnt) {
                    cnt = tpCnt
                    ans = lastNum
                }
                tpCnt = 0
            }
            // 当前偶数的次数+1
            tpCnt++
            lastNum = nums[i]
        }

        // 最后可能得处理
        if(lastNum != -1 && tpCnt > cnt) {
            ans = lastNum
        }

        // 最后的数字要处理
        return ans;
    }

}