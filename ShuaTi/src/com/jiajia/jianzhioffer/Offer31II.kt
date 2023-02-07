package com.jiajia.jianzhioffer

import com.jiajia.common.TreeNode
import java.util.*
import kotlin.collections.ArrayList

class Offer31II {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return ArrayList()
        }
        val list = ArrayList<List<Int>>()
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while (!queue.isEmpty()) {
            val cnt = queue.size
            val row = ArrayList<Int>()
            for (i in 0 until cnt) {
                val node = queue.poll()
                node?.let {
                    row.add(it.`val`)
                    if (node.left != null) {
                        queue.add(node.left)
                    }
                    if (node.right != null) {
                        queue.add(node.right)
                    }
                }
            }
            list.add(row)
        }
        return list
    }
}