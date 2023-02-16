package com.jiajia.daily

/**
 * 2341. 数组能形成多少数对
 */
class Solution20230216 {

    fun numberOfPairs(nums: IntArray): IntArray {
        val list = ArrayList<Int>()
        var pairNum = 0
        for (num in nums) {
            if (list.contains(num)) {
                pairNum++
                list.remove(num)
            } else {
                list.add(num)
            }
        }
        return intArrayOf(pairNum, nums.size - pairNum * 2)

        // 这个方法速度不好，因为借助了ArrayList，做哈希查找之类的。
        // 可以先排序，然后从前往后，比较和前一个是否相同就好了。
    }
}