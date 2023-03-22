package com.jiajia.daily

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.sign

class Solution20230322 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230322()
            println(s.bestTeamScore(intArrayOf(9,2,8,8,2), intArrayOf(4,1,3,3,5)))
        }
    }

    private var maxScore = 0
    private var path = ArrayList<Int>()

    fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
//        backTracking(scores, ages, 0, 0)
        return method(scores, ages)
    }

    /**
     * 递归回溯，超出了时间限制
     */
    private fun backTracking(scores: IntArray, ages: IntArray, index: Int, score: Int) {
        // 更新分数
        if (score > maxScore) {
            maxScore = score
            println(path.joinToString(separator = ","))
        }
        // 不再继续往下走了
        if (index >= scores.size) {
            return
        }
        for (i in index until scores.size) {
            if (!valid(scores, ages, i)) {
                continue
            }
            // 累加
            path.add(i)
            backTracking(scores, ages, i + 1, score + scores[i])
            // 回溯
            path.removeAt(path.size - 1)
        }
    }

    /**
     * 校验当前i是否满足
     */
    private fun valid(scores: IntArray, ages: IntArray, i:Int): Boolean {
        for (j in path) {
            if (ages[j] > ages[i] && scores[j] < scores[i]
                || ages[i] > ages[j] && scores[i] < scores[j]) {
                return false
            }
        }
        return true
    }

    /**
     * dp
     */
    private fun method(scores: IntArray, ages: IntArray): Int {
        val people = Array(scores.size) { IntArray(2) }
        for (i in scores.indices) {
            people[i][0] = scores[i]
            people[i][1] = ages[i]
        }
        Arrays.sort(people) {o1,o2 -> if (o1[0] == o2[0]) o1[1] - o2[1] else o1[0] - o2[0]}

        val dp = IntArray(people.size)
        var ans = 0
        for (i in people.indices) {
            for (j in i - 1 downTo 0) {
                if (people[j][1] <= people[i][1]) { // 前面的分数一定是小于后面的分数的,同龄人不矛盾
                    dp[i] = dp[i].coerceAtLeast(dp[j])
                }
            }
            dp[i] += people[i][0]
            ans = ans.coerceAtLeast(dp[i])
        }
        return ans
    }
}