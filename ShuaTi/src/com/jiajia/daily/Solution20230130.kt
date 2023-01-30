package com.jiajia.daily

import com.jiajia.common.ListNode

/**
 * 1669. 合并两个链表
 * <a href="https://leetcode.cn/problems/merge-in-between-linked-lists">链接</a>
 */
class Solution20230130 {

    /**
     * [0,1,2,3,4,5]
     * 3   4
     * [1000000,1000001,1000002]
     *
     * exp: [0,1,2,1000000,1000001,1000002,5]
     * err: [0,1000000,1000001,1000002,2,3,4,5]
     *
     */
    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        // 找到a前面那个，并找个临时指针temp指向a。这里注意a可能是第一个
        // temp指针一直走到b，找到b后面拿一个，并将b最后一个放到list2的最后
        var list1HeadPre: ListNode? = list1
        var list1Head: ListNode? = list1
        var i = 0
        while (i < a) {
            list1HeadPre = list1Head
            list1Head = list1Head?.next
            i++
        }
        list1HeadPre?.next = list2;

        // 继续往下走
        while (i < b) {
            list1Head = list1Head?.next
            i++ // 会一直走到b上面
        }

        var list2Head = list2
        while (list2Head?.next != null) {
            list2Head = list2Head.next
        }

        list2Head?.next = list1Head?.next // b的下一个
        return list1
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val list1 = ListNode.buildList(intArrayOf(0, 1, 2, 3, 4, 5, 6))
            val list2 = ListNode.buildList(intArrayOf(1000000, 1000001, 1000002, 1000003, 1000004))

            val s = Solution20230130()
            println(s.mergeInBetween(list1, 2, 5, list2));
        }
    }

}