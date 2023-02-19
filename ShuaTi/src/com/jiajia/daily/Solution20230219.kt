package com.jiajia.daily

import java.util.PriorityQueue

/**
 * 1792. 最大平均通过率
 */
class Solution20230219 {

    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        // 优先级队列，按照通过率的增量进行排序，增量大的放在前面
        val queue = PriorityQueue<IntArray> { a, b ->
            val o1 = 1.0 * (b[1] + 1) * b[1] * (a[1] - a[0])
            val o2 = 1.0 * (a[1] + 1) * a[1] * (b[1] - b[0])
            if (o1 == o2) {
                0
            } else {
                if (o1 < o2) 1 else -1
            }
        }

        for (cls in classes) {
            queue.offer(cls)
        }

        for (i in 0 until extraStudents) {
            val arr = queue.poll()
            arr[0]++
            arr[1]++
            queue.offer(arr)
        }

        var cnt = 0.0
        for (arr in queue) {
            cnt += 1.0 * arr[0] / arr[1]
        }

        return cnt / queue.size

    }

}