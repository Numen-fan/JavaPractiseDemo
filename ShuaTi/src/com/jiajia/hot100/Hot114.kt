package com.jiajia.hot100

import com.jiajia.common.TreeNode
import com.jiajia.kit.ArrayUtils
import java.util.LinkedList

class Hot114 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val root = TreeNode.buildTree(arrayOf(1,2,5,3,4,null,6))
            val h = Hot114()
            h.flatten(root)
        }
    }

    val queue = LinkedList<TreeNode>()
    fun flatten(root: TreeNode?): Unit {
        preOrder(root)
        if (queue.isEmpty()) {
            return
        }
        var preNode = queue.pop()
        while (queue.isNotEmpty()) {
            preNode.right = queue.peek()
            preNode.left = null
            preNode = queue.pop()
            preNode.right = null
        }
    }

    private fun preOrder(root: TreeNode?) {
        root?.let {
            queue.add(it)
            preOrder(it.left)
            preOrder(it.right)
        }
    }

}