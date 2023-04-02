package com.jiajia.hot100

import com.jiajia.common.ListNode
import java.util.PriorityQueue

class Hot148 {

    fun sortList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        return method1(head)
    }

    /**
     * 先到队列中
     */
    private fun method1(head: ListNode): ListNode? {
        val queue = PriorityQueue<ListNode> { o1, o2 -> o1.`val` - o2.`val` }
        var node: ListNode? = head
        while (node != null) {
            queue.add(node)
            node = node.next
        }

        var head: ListNode? = null
        var pre: ListNode? = null
        while (queue.isNotEmpty()) {
            if (pre == null) {
                pre = queue.poll()
                head = pre
            } else {
                pre.next = queue.peek()
                pre = queue.poll()
                pre.next = null // 这里必须断开
            }
        }
        return head
    }
}