package com.jiajia.jianzhioffer

import com.jiajia.common.TreeNode

/**
 * 剑指 Offer 27. 二叉树的镜像
 */
class Offer27 {

    fun mirrorTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return root
        }
        val node = root.left
        root.left = root.right
        root.right = node
        mirrorTree(root.left)
        mirrorTree(root.right)
        return root
    }

}