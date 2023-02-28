package com.jiajia.jianzhioffer

import com.jiajia.kit.ArrayUtils
import java.util.LinkedList

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 */
class Offer59IImportant {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer59IImportant()
            ArrayUtils.print(o.maxSlidingWindow(intArrayOf(-7,-8,7,5,7,1,6,0), 4))
        }
    }

    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty()) {
            return nums
        }

        val deque = LinkedList<Int>()
        for (i in 0 until k) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast()
            }
            deque.offer(nums[i])
        }
        val list = ArrayList<Int>()
        list.add(deque.peek()) // 第一个窗口的最大值
        for (i in k until nums.size) {
            // 先移除窗口左边的元素
            if (nums[i - k] == deque.peek()) {
                deque.pop()
            }
            // 添加新的元素
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast()
            }
            deque.offer(nums[i])
            list.add(deque.peek())
        }
        return list.toIntArray()
    }
}