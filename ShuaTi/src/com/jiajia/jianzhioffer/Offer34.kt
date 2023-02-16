package com.jiajia.jianzhioffer

import com.jiajia.common.TreeNode
import java.util.Collections

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 */
class Offer34 {

    private val path = ArrayList<List<Int>>()
    private val tempPath = ArrayList<Int>()

    fun pathSum(root: TreeNode?, target: Int): List<List<Int>> {
        backTracking(root, target)
        return path
    }

    private fun backTracking(root: TreeNode?, rest: Int) {
        if (root == null) {
            return
        }

        // 先将当前节点加入路径之中
        tempPath.add(root.`val`)

        // 得判断当前节点是否是子节点
        if (root.left == null && root.right == null && root.`val` == rest) {
            path.add(ArrayList(tempPath))
            tempPath.removeAt(tempPath.size - 1) // 回溯移除本层加入的节点
            return
        }

        // 左右节点
        root.left?.let {
            backTracking(it, rest - root.`val`)
        }

        root.right?.let {
            backTracking(it, rest - root.`val`)
        }
        tempPath.removeAt(tempPath.size - 1) // 回溯移除本层加入的节点

    }
}