package com.jiajia.jianzhioffer

import com.jiajia.common.TreeNode
import kotlin.math.max

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 */
class Offer51I {

    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return maxDepth(root.left).coerceAtLeast(maxDepth(root.right)) + 1

    }

}