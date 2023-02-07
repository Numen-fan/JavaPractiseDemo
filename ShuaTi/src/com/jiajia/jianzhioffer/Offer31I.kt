package com.jiajia.jianzhioffer

import com.jiajia.common.TreeNode
import java.util.LinkedList

class Offer31I {
    fun levelOrder(root: TreeNode?): IntArray {
        if (root == null) {
            return IntArray(0)
        }
        val list = ArrayList<Int>()
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while (!queue.isEmpty()) {
            val cnt = queue.size
            for (i in 0 until cnt) {
                val node = queue.poll()
                node?.let {
                    list.add(it.`val`)
                    if (node.left != null) {
                        queue.add(node.left)
                    }
                    if (node.right != null) {
                        queue.add(node.right)
                    }
                }
            }
        }
        return list.toIntArray()
    }
}