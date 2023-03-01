package com.jiajia.jianzhioffer

import com.jiajia.common.TreeNode
import java.util.*

/**
 * 剑指 Offer 37. 序列化二叉树
 */
class Offer37 {

    companion object {
        const val NULL_NODE = "null"
    }

    /**
     * 这里不限制返回的字符串格式，你自己能够识别就ok了
     */
    fun serialize(root: TreeNode?): String {
        if (root == null) {
            return NULL_NODE
        }
        val sb = StringBuilder()
        // 广度遍历
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        while (!queue.isEmpty()) {
            val cnt = queue.size
            // 处理这一层的节点
            for (i in 0 until cnt) {
                val node = queue.pop() // 取出当前节点
                if (node == null) {
                    sb.append("$NULL_NODE,")
                } else {
                    sb.append("${node.`val`},")
                    queue.offer(node.left)
                    queue.offer(node.right)
                }
            }
        }
        return sb.toString().substring(0, sb.length - 1)
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (NULL_NODE == data) {
            return null
        }
        // 仍然采用宽度优先遍历去做
        val nodes = data.split(",")
        val root = TreeNode(nodes[0].toInt())
        if (nodes.size == 1) {
            return root
        }

        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        var index = 1 // 下一个字符

        while (!queue.isEmpty() && index < nodes.size) {
            val cnt = queue.size
            // 为这一层的节点设置左右节点
            for (i in 0 until cnt) {
                if (index >= nodes.size) {
                    break
                }
                val curNode = queue.pop()
                // 为当前节点设置左节点
                if (nodes[index] != NULL_NODE) {
                    curNode.left = TreeNode(nodes[index].toInt())
                    queue.offer(curNode.left) // 加到队列中，后面为他设置左右节点
                }

                index++ // 这里必须加一个

                if (index < nodes.size) {
                    // 为当前节点设置右节点
                    if (nodes[index] != NULL_NODE) {
                        curNode.right = TreeNode(nodes[index].toInt())
                        queue.offer(curNode.right)
                    }
                    index++ // 需要在这里+1
                }
            }
        }
        return root
    }

}