package com.jiajia.jianzhioffer

import com.jiajia.common.ListNode

/**
 * 剑指 Offer 18. 删除链表的节点
 */
class Offer18Important {
    fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
        var newHead: ListNode? = null
        var preNode: ListNode? = null
        var curNode = head
        while (curNode != null) {
            if (newHead == null && curNode.`val` != `val`) { // 这里可以直接先while找到第一个非val的节点作为新的头结点
                newHead = curNode // 新的头结点
                preNode = newHead
            }
            if (curNode.`val` == `val`) {
                if (preNode != null) {
                    preNode.next = curNode.next
                    preNode = curNode
                }
            } else {
                preNode = curNode
            }
            curNode = curNode.next
        }
        return newHead

    }

    private fun method1(head: ListNode?, `val`: Int): ListNode? {
        var newHead = head
        while (newHead != null && newHead.`val` == `val`) {
            newHead = newHead.next
        }
        if (newHead == null) {
            return newHead
        }

        var preNode = newHead
        var curNode = newHead.next
        while (curNode != null) {
            if (curNode.`val` == `val`) {
                preNode?.next = curNode.next
            }
            preNode = curNode
            curNode = curNode.next
        }
        return newHead
    }
}