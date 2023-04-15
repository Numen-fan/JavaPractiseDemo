package com.jiajia.daily

import com.jiajia.common.ListNode

class Solution20230410 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230410()
            println(s.nextLargerNodes(ListNode.buildList(intArrayOf(9, 7, 6, 7, 6, 9))).contentToString())
        }
    }

    fun nextLargerNodes(head: ListNode?): IntArray {
        val list = ArrayList<Int>()
        var node = head
        var index = 0 // 当前处理的节点
        while (node != null) {
            // 寻找node之后的最大值
            // 先更新最大值
            var max = node.`val`
            var tNode = node
            var tIndex = index
            while (tNode != null) {
                if (tNode.`val` > max) {
                    max = tNode.`val`
                    break
                }
                tNode = tNode.next
                tIndex++
            }
            // 找到了离当前节点最大的节点
            list.add(if (tNode == null) 0 else max)
            node = node.next
            index++
        }
        return list.toIntArray()
        // [7,9,9,9,0,5,0,0]
    }

}