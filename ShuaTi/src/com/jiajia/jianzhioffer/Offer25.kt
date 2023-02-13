package com.jiajia.jianzhioffer

import com.jiajia.common.ListNode

/**
 * 剑指 Offer 25. 合并两个排序的链表
 */
class Offer25 {

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1Head = l1
        var l2Head = l2
        if (l1 == null) {
            return l2
        } else if (l2 == null) {
            return l1
        }
        val preHead = ListNode(-1)
        var preNode:ListNode = preHead // 这里其实可以new一个新的节点，作为哨兵使用，最后返回.next即可【关键】
        while (l1Head != null && l2Head != null) {
            if (l1Head.`val` <= l2Head.`val`) {
                preNode.next = l1Head
                preNode = preNode.next
                l1Head = l1Head.next
            } else {
               preNode.next = l2Head
               preNode = preNode.next
               l2Head = l2Head.next
            }
        }

        if (l1Head != null) {
            preNode.next = l1Head
        }
        if (l2Head != null) {
            preNode.next = l2Head
        }
        return preHead.next
    }
}