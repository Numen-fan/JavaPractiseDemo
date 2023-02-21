package com.jiajia.jianzhioffer

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 */
class Offer33Important {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer33Important()
            println(o.verifyPostorder(intArrayOf(4, 8, 6, 12, 16, 14, 10)))
        }
    }

    fun verifyPostorder(postorder: IntArray): Boolean {
        return verify(postorder, 0, postorder.size - 1)
    }

    /**
     * 判断left 到 right 是否满足一颗二叉搜索树的后序遍历
     */
    private fun verify(postorder: IntArray, left: Int, right: Int): Boolean {
        if (left >= right) { // 越界了，说明肯定满足了
            return true
        }

        val rootValue = postorder[right] // 最后一个元素就是当前二叉搜索树的root节点

        var k = left
        while (k < right && postorder[k] < rootValue) {
            k++
        }

        // 当前k指向第一个大于rootValue的值，那么left ~ k - 1的就是root的左子树
        // 判断k - right - 1是否存在小于root的值，如果存在就表示不满足了
        for (i in k until right) {
            if (postorder[i] < rootValue) {
                return false
            }
        }

        // 从k分界，满足当前的条件，接下来继续判断左右子树的情况
        return verify(postorder, left, k - 1) && verify(postorder, k, right - 1)
    }

}