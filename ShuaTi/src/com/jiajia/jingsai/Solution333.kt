package com.jiajia.jingsai

import com.jiajia.kit.ArrayUtils
import kotlin.math.abs

class Solution333 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution333()
            println(1e2)
//            println(ArrayUtils.print(s.mergeArrays(ArrayUtils.string2IntArray2("[[148,597],[165,623],[306,359],[349,566],[403,646],[420,381],[566,543],[730,209],[757,875],[788,208],[932,695]]"), ArrayUtils.string2IntArray2( "[[74,669],[87,399],[89,165],[99,749],[122,401],[138,16],[144,714],[148,206],[177,948],[211,653],[285,775],[309,289],[349,396],[386,831],[403,318],[405,119],[420,153],[468,433],[504,101],[566,128],[603,688],[618,628],[622,586],[641,46],[653,922],[672,772],[691,823],[693,900],[756,878],[757,952],[770,795],[806,118],[813,88],[919,501],[935,253],[982,385]]"))))
//            println(s.squareFreeSubsets(intArrayOf(8,11,17,2,25,29,21,20,4,22)))

            println(s.minOperations(74415))
        }
    }

    /**
     * 6362. 合并两个二维数组 - 求和法
     */
    fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
        var map = HashMap<Int, Int>()

        for (arr in nums1) {
            map[arr[0]] = arr[1]
        }

        for (arr in nums2) {
            var res = map.getOrDefault(arr[0], 0)
            map[arr[0]] = res + arr[1]
        }

        val list = map.entries.sortedBy { it.key }

        val ans = Array(list.size){IntArray(2)}

        var i = 0
        for ((key, value) in list) {
            ans[i++] = intArrayOf(key, value)
        }
        return ans
    }

    /**
     * 6365. 将整数减少到零需要的最少操作数
     */
    fun minOperations(n: Int): Int {
        val list = ArrayList<Int>()
        var late = 1
        list.add(late)
        while (late <= 100000) {
            late *= 2
            list.add(late) // 能保证最后一个数大于100000
        }

        var ans = 0
        var num = n
        while (num != 0) {
            ans++
            val i = binarySearch(list, num)
            num = abs(list[i] - num)
        }

        return ans
    }

    private fun binarySearch(list: List<Int>, target: Int): Int {
        var l = 0
        var r = list.size - 1
        while (l <= r) {
            val mid = (l + r) / 2
            if (list[mid] == target) {
                return mid
            }
            if (list[mid] > target) {
                r = mid - 1
            } else { // list[mid] < target
                l = mid + 1
            }
        }
        return if (abs(list[r] - target) < abs(target - list[l])) r else l
    }

    /**
     * 6364. 无平方子集计数
     */
    var ans = 0
    private val mod: Int = (1e9 + 7).toInt()

    val list = ArrayList<Int>()
    fun squareFreeSubsets(nums: IntArray): Int {
        backTracking(nums, 0, 1)
        return ans
    }

    private fun backTracking(nums: IntArray, start: Int, count: Int) {
        // 继续选择后面的节点
        for (i in start until nums.size) {
            val res = ((count % mod) * (nums[i] % mod)) % mod
            // 判断当前的count是否满足
            list.add(nums[i])
            if (match(res)) {
                ans = (ans + 1) % mod
                println(list)
            }
            backTracking(nums, i + 1, res)
            // 用了形参，这里就不需要做回溯了
            list.removeAt(list.size - 1)
        }
    }

    private fun match(count: Int): Boolean {
        var i = 2
        var res = 0
        while (res <= count / 2) {
            res = i * i
            if (count % res == 0) { // 被某个平方数整除了
                return false
            }
            i++
        }
        return true
    }

}