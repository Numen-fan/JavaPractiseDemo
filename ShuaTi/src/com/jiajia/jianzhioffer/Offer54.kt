package com.jiajia.jianzhioffer

import com.jiajia.common.TreeNode

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 */
class Offer54 {

    val list = ArrayList<Int>()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer54()
            println(o.kthLargest(TreeNode.buildTree(arrayOf(3,1,4,null,2)), 1))
        }
    }

    fun kthLargest(root: TreeNode?, k: Int): Int {
        dfs(root)
        return list[list.size - k]
    }

    fun dfs(root: TreeNode?) {
        if (root == null) {
            return
        }
        dfs(root.left)

        list.add(root.`val`)

        dfs(root.right)
    }



}