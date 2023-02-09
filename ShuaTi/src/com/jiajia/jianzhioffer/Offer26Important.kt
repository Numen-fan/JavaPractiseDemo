package com.jiajia.jianzhioffer

import com.jiajia.common.TreeNode

/**
 * 剑指 Offer 26. 树的子结构
 */
class Offer26Important {

    fun isSubStructure(A: TreeNode?, B: TreeNode?): Boolean {
        if (A == null || B == null) {
            return false
        }
        return isSameTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)
    }

    private fun isSameTree(A: TreeNode?, B: TreeNode?): Boolean {
        if (B == null) { // 说明B已经到头了
            return true
        }
        if (A == null || A.`val` != B.`val`) {
            return false
        }
        return isSameTree(A.left, B.left) && isSameTree(A.right, B.right)
    }

}