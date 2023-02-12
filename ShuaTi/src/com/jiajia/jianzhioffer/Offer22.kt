package com.jiajia.jianzhioffer

import com.jiajia.common.ListNode
import com.jiajia.kit.ArrayUtils

class Offer22 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer22()
            o.getKthFromEnd(ListNode.buildList(ArrayUtils.string2IntArray("[1,2,3,4,5]")), 2)
        }
    }

    fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
        if (head == null) {
            return head
        }
        var fastNode = head
        var slowNode = head
        for (i in 1 ..k) { // 走k次，因为最后fastNode是需要到null，也就是最后一个元素的后一个
            fastNode = fastNode?.next
        }
        while (fastNode != null) {
            fastNode = fastNode.next
            slowNode = slowNode?.next
        }

        return slowNode
    }

}