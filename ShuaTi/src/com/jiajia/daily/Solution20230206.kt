package com.jiajia.daily

import com.jiajia.common.TreeNode

class Solution20230206 {

    fun evaluateTree(root: TreeNode?): Boolean {
        if (root == null) {
            return false
        }
        if (root.left == null && root.right == null) {
            // 叶子节点
            return root.`val` == 1
        }
        val leftVal = evaluateTree(root.left)
        val rightVal = evaluateTree(root.right)
        return if (root.`val` == 2) {
            leftVal || rightVal
        } else {
            leftVal && rightVal
        }
    }
}