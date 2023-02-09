package com.jiajia.jianzhioffer

import com.jiajia.common.TreeNode

/**
 * 是否是对称二叉树
 */
class Offer28Important {

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return isSymmetric(root.left, root.right)
    }

    /**
     * A 和 B要相同，A的left和B的right要相同，A的right和B的left要相同
     */
    private fun isSymmetric(A: TreeNode?, B: TreeNode?): Boolean {
        if (A == null && B == null) {
            return true
        }

        if (A == null || B == null) {
            return false
        }
        return A.`val` == B.`val` && isSymmetric(A.left, B.right) && isSymmetric(A.right, B.left)
    }

}