package com.jiajia.jianzhioffer

class Offer62 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer62()
            println(o.method(10, 17))
        }
    }

    fun lastRemaining(n: Int, m: Int): Int {
        val arr = IntArray(n)
        for (i in arr.indices) {
            arr[i] = i
        }

        var cnt = 0
        var index = 0 // 走的起点
        while (cnt < n - 1) {
            // 本轮计数, 往前数m-1个数，因为当前在第一个数上面
            for (i in 0 until m - 1) {
                index = (index + 1) % n // 先走
                while (arr[index] == -1) {
                    index = (index + 1) % n // 一定要确保这一步走到了没被删除的数上面
                }
            }

            arr[index] = -1; // 删除这个数
            cnt++ // 删除操作加1
            // 定位到下一个
            while (arr[index] == -1) {
                index = (index + 1) % n
            }
        }

        for (i in arr) {
            if (i != -1) {
                return i
            }
        }
        return 0

    }

    private fun method(n: Int, m: Int): Int {
        val list = ArrayList<Int>()
        for (i in 0 until n) {
            list.add(i)
        }
        var index = 0
        while (list.size != 1) {
            for (i in 0 until m - 1) { // 这里有m次
                index = (index + 1) % list.size
            }
            list.removeAt(index)
        }
        return list[0]
    }
}