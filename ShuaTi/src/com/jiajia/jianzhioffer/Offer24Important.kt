package com.jiajia.jianzhioffer

import com.jiajia.common.ListNode

/**
 * 剑指 Offer 24. 反转链表
 */
class Offer24Important {

    fun reverseList(head: ListNode?): ListNode? {
        var preNode:ListNode? = null
        var curNode = head;
        var next: ListNode? = null;
        while (curNode != null) {
            next = curNode.next // 记录下一个节点
            curNode.next = preNode // 当前节点的next指向前一个节点
            preNode = curNode; // 前一个节点移动到当前节点
            curNode = next // 继续下一个节点
        }
        return preNode
    }

    /**
     * 递归来做一下
     */
    fun reverseList2(head: ListNode?): ListNode? {
        // 最后一个节点
        if (head?.next == null) {
            return head
        }
        var newHead = reverseList2(head.next)
        head.next.next = head
        head.next = null
        return newHead;
    }

}