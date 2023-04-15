package com.jiajia.daily

class Solution20230415 {

    fun gardenNoAdj(n: Int, paths: Array<IntArray>): IntArray {
        // 先建立邻接表
        val adj = Array(n) { ArrayList<Int>() } // {}内是用于初始化每个元素的
        for (path in paths) {
            adj[path[0] - 1].add(path[1] - 1) // path的编号是从1-n
            adj[path[1] - 1].add(path[0] - 1)
        }

        //
        val ans = IntArray(n) // ans[i] 第i个花园的花编号，1~4
        for (i in 0 until n) {
            val colored = BooleanArray(5) // 标记num的邻接几个花园的花，一共只有4种，0不会被用到
            for (a in adj[i]) {
                colored[ans[a]] = true // 表示i的邻接a使用的花色
            }

            // 对i进行染色
            for (j in 1..4) {
                if (!colored[j]) {
                    ans[i] = j // 第i号花园的花色编号为j
                    break // 结束
                }
            }
        }
        return ans
    }

}