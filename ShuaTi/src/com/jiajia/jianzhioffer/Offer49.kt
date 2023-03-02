package com.jiajia.jianzhioffer

import java.util.PriorityQueue

class Offer49 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer49()
            println(o.nthUglyNumber(1407))
        }
    }

    /**
     * 第一个丑数是n，下一个丑数是2n 3n 5n中最小的哪一个, 并且将2n 3n 5n都放到队列中
     * 使用优先队列实现，并且使用set进行拍重
     */
    fun nthUglyNumber(n: Int): Int {
        val set = HashSet<Long>()
        val queue = PriorityQueue<Long>()
        queue.offer(1)
        set.add(1)
        var ugly:Int = 0
        val factors = intArrayOf(2, 3, 5)
        for (i in 0 until n) {
            val curUgly = queue.poll();
            ugly = curUgly.toInt() // 取最小的那一个丑数
            for (k in factors) {
                val next = curUgly * k
                if (set.add(next)) {
                    queue.offer(next)
                }
            }
        }
        return ugly
    }

}