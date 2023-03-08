package com.jiajia.hot100

import com.jiajia.common.ListNode
import java.util.PriorityQueue

/**
 * 23. 合并K个排序链表
 */
class Hot23 {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isNullOrEmpty()) {
            return null
        }

        val queue = PriorityQueue<ListNode> { node1, node2 -> node1.`val` - node2.`val` }
        for (list in lists) {
            if (list != null) {
                queue.offer(list)
            }
        }
        var head: ListNode? = null
        var lastNode: ListNode? = null
        while (!queue.isEmpty()) {
            val node = queue.poll()
            if (node.next != null) { // 先将这个节点的下一个节点如队列
                queue.offer(node.next)
            }
            if (head == null) {
                head = node
            } else {
                lastNode!!.next = node
            }
            lastNode = node

        }
        return head
    }

}