package com.jiajia.jingsai

class Solution339 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution339()
            println(s.miceAndCheese(intArrayOf(1,1,3,4), intArrayOf(4,4,1,1), 2))
        }
    }

    /**
     * 6362. 最长平衡子字符串
     */
    fun findTheLongestBalancedSubstring(s: String): Int {
        var ans = 0
        for (i in s.indices) {
            if (s[i] == '1') {
                continue
            }
            var zeroCnt = 1
            var oneCnt = 0
            for (j in i + 1 until s.length) {
                if (oneCnt > 0 && s[j] == '0') {
                    if (zeroCnt == oneCnt) {
                        ans = ans.coerceAtLeast(zeroCnt + oneCnt)
                    }
                    break // 不需要继续进行了
                }
                if (s[j] == '0') {
                    zeroCnt++
                } else {
                    oneCnt++
                }
                if (zeroCnt == oneCnt) {
                    ans = ans.coerceAtLeast(zeroCnt + oneCnt)
                    break // 不需要继续进行了
                }
                // 还有退出的情况
            }
        }
        return ans
    }

    /**
     * 6363. 转换二维数组
     */
    fun findMatrix(nums: IntArray): List<List<Int>> {
        val map = HashMap<Int, Int>()
        for (n in nums) {
            val cnt = map.getOrDefault(n, 0) + 1
            map[n] = cnt
        }
        val ans = ArrayList<ArrayList<Int>>()
        while (map.isNotEmpty()) {
            val list = ArrayList<Int>()
            val r = ArrayList<Int>()
            for ((k, v) in map) {
                list.add(k)
                if (v - 1 == 0) {
                    r.add(k)
                } else {
                    map[k] = v - 1
                }
            }
            for (n in r) {
                map.remove(n)
            }
            ans.add(list)
        }
        return ans
    }

    /**
     * 6364. 老鼠和奶酪
     */
    fun miceAndCheese(reward1: IntArray, reward2: IntArray, k: Int): Int {
        val n = reward1.size
        val mat = Array(n) { IntArray(2) }
        for (i in reward2.indices) {
            mat[i][0] = reward1[i]
            mat[i][1] = reward2[i]
        }
//        mat.sortWith(comparator = Comparator{o1, o2 -> if (o1[0] != o2[0]) o2[0] - o1[0] else o1[1] - o2[1]})
        mat.sortWith(comparator = Comparator{o1, o2 -> (o2[0] - o2[1]) - (o1[0] - o1[1])})
        var ans = 0
        for (i in 0 until k) {
            ans += mat[i][0]
        }
        for (i in k until n) {
            ans += mat[i][1]
        }
        return ans
    }
}