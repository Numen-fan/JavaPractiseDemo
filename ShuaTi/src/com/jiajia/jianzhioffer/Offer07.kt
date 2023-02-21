package com.jiajia.jianzhioffer

import com.jiajia.common.TreeNode

/**
 * 剑指 Offer 07. 重建二叉树
 */
class Offer07 {


    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return method1(preorder, inorder)
    }

    private fun method1(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) {
            return null
        }

        // root就是preorder[0]
        val root = TreeNode(preorder[0])

        // 拿到前序遍历中第一个元素在中序遍历序列中的下标
        val index = inorder.indexOf(preorder[0])
        // 在中序遍历中[0 - index - 1]是root的左子树 [index+1 - inorder.size - 1]是root的右边子树
        root.left = method1(preorder.copyOfRange(1, 1 + index), inorder.copyOfRange(0, index))
        root.right = method1(preorder.copyOfRange(1 + index, preorder.size), inorder.copyOfRange(index + 1, inorder.size))

        return root
    }

}