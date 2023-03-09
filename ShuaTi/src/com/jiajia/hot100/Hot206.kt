package com.jiajia.hot100

import com.jiajia.common.ListNode

class Hot206 {

    fun reverseList(head: ListNode?): ListNode? {
        return method1(head)
    }

    /**
     * 双指针迭代方法
     */
    private fun method1(head: ListNode?): ListNode? {
        var preNode: ListNode? = null // 前一个节点
        var curNode = head // 当前节点
        var nextNode: ListNode? = null // 下一个节点
        while (curNode != null) {
            nextNode = curNode.next // 下一个节点得记住
            curNode.next = preNode
            preNode = curNode
            curNode = nextNode
        }
        return preNode
    }

    /**
     * 递归
     * 核心思想，当前节点必须要知道前一个节点
     */
    private fun method2(preNode: ListNode?, curNode: ListNode?): ListNode? {
        if (curNode == null) {
            return preNode // 说明到最后了，那么前一个节点就是尾节点，反转后的头结点
        }
        val nextNode = curNode.next // 首先要记录下一个节点
        curNode.next = preNode // 修改当前节点的next指针
        return method2(curNode, nextNode)
    }

}