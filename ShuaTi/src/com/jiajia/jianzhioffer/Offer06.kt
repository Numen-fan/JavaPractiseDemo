package com.jiajia.jianzhioffer

import com.jiajia.common.ListNode

/**
 * 剑指 Offer 06. 从尾到头打印链表
 */
class Offer06 {

    fun reversePrint(head: ListNode?): IntArray {
        val list = ArrayList<Int>()
        var node = head
        while (node != null) {
            list.add(node.`val`)
            node = node.next
        }
        return list.toIntArray().reversedArray();
    }

}