package com.jiajia.jianzhioffer

import com.jiajia.common.TreeNode
import kotlin.math.max

class Offer55II {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        val leftBalance = isBalanced(root.left)
        val  rightBalance = isBalanced(root.right)
        return leftBalance && rightBalance && Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
    }

    private fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return maxDepth(root.left).coerceAtLeast(maxDepth(root.right)) + 1
    }

}