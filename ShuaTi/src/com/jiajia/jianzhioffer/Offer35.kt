package com.jiajia.jianzhioffer

import com.jiajia.common.ListNode

/**
 * 剑指 Offer 35. 复杂链表的复制
 */
class Offer35 {

    val map = HashMap<ListNode, ListNode>()
    fun copyRandomList(head: ListNode?): ListNode? {
        // 利用递归回溯的方法，递归创建对应节点的深度节点，然后在回溯的过程中，取对应节点的random节点
        if (head == null) {
            return head
        }
        if (!map.containsKey(head)) {
            val node = ListNode(head.`val`)
            map[head] = node
            node.next = copyRandomList(head.next)
            // 这一步回溯做的非常妙
            node.random = copyRandomList(head.random)
        }
        return map.get(head) // 当前head的深复制节点
    }
}