package com.jiajia.daily

class Solution20230309 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230309()
            println(s.method3("WBBWWBBWBW", 7))
            println(s.method3("BBBBBWWBBWBWBWWWBWBWBBBBWBBBBWBWBWBWBWWBWWBWBWWWWBBWWWWBWWWWBWBBWBBWBBWWW", 29))
        }
    }

    fun minimumRecolors(blocks: String, k: Int): Int {
        return method1(blocks, k)
    }

    /**
     * 暴力解法
     */
    private fun method1(blocks: String, k: Int): Int {
        var ans = blocks.length
        for (i in 0 until blocks.length - k + 1) {
            var t = 0
            for (j in 0 until k) {
                if (blocks[i + j] == 'W') {
                    t++
                }
            }
            ans = ans.coerceAtMost(t)
        }
        return ans
    }

    /**
     * 前缀和
     */
    private fun method2(blocks: String, k: Int): Int {
        var ans = blocks.length
        val n = blocks.length
        // 前缀和
        val f = IntArray(blocks.length + 1)
        for (i in 0 until n) {
            f[i + 1] = f[i] + if(blocks[i] == 'W') 0 else 1
        }
        // 从后向前找
        for (i in f.size - 1 downTo k) {
            ans = ans.coerceAtMost(k - (f[i] - f[i - k]))
        }
        return ans
    }

    /**
     * 滑动窗口
     */
    private fun method3(blocks: String, k: Int): Int {
        var w = 0
        for (i in 0 until k) {
            w += if(blocks[i] == 'W') 1 else 0
        }
        var ans = w // 初始滑动窗口内白色的数量
        var l = 0
        var r = k - 1
        // 开始滑动窗口
        while (r < blocks.length - 1) {
            r++
            l++
            // 去掉左边的元素
            w -= if(blocks[l - 1] == 'W') 1 else 0
            // 添加右边的元素
            w += if (blocks[r] == 'W') 1 else 0
            ans = ans.coerceAtMost(w)
        }
        return ans

    }
}