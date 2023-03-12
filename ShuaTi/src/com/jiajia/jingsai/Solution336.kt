package com.jiajia.jingsai

import com.jiajia.kit.ArrayUtils
import java.util.Arrays
import java.util.Collections
import kotlin.test.assertNotEquals

class Solution336 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution336()
            val tasks = ArrayUtils.string2IntArray2("[[8,19,1],[3,20,1],[1,20,2],[6,13,3]]")
            println(s.findMinimumTime(tasks))
        }
    }

    fun vowelStrings(words: Array<String>, left: Int, right: Int): Int {
        var ans = 0
        val arr = arrayOf('a', 'e', 'i', 'u', 'o')
        for (i in left .. right) {
            val word = words[i]
            ans += if (arr.contains(word[0]) && arr.contains(word[word.length - 1])) 1 else 0
        }
        return ans
    }

    /**
     * 6316. 重排数组以得到最大前缀分数
     */
    fun maxScore(nums: IntArray): Int {
        nums.sort()
        nums.reverse()
        var ans = 0
        var preSum:Long = 0
        for (num in nums) {
            preSum += num
            if (preSum <= 0) {
                break
            }
            ans++
        }
        return ans
    }

    /**
     * 6318. 完成所有任务的最少时间
     *【AC】
     */
    fun findMinimumTime(tasks: Array<IntArray>): Int {
        tasks.sortWith(Comparator { o1, o2 -> o1[1] - o2[1]}) // 按照截止时间排序
        val workTime = HashSet<Int>() // 记录开机的时间点
        for ((start, end, count) in tasks) {
            var consume = 0 // 在workTime中的开机时间可以消耗掉的次数
            for (time in workTime) {
                if (time in start..end) { // 如果在这个区间范围内有开机的时间，那么就执行一次
                    consume++
                }
                if (consume >= count) {
                    break // 消耗完了
                }
            }

            // 剩下没有被消耗的，则从end开始依次往前消耗
            var latest = count - consume
            var consumeTime = end // 从后往前
            while (latest > 0) {
                while (workTime.contains(consumeTime)) {
                    consumeTime--
                }
                latest--
                workTime.add(consumeTime)
            }
        }
        return workTime.size
    }

}