package com.jiajia.jingsai

import com.jiajia.common.TreeNode
import java.util.LinkedList

class Solution335 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution335()
            println(s.passThePillow(3, 2))
            println(s.findValidSplit(intArrayOf(4,7,8,15,3,5)))
//            println(s.findValidSplit(intArrayOf(312743,312743,878413,443689,999773,707797,389569,495713,370879,415141,988829,356621,44111,43151,325883,397357,159839,852851,230611,312743,761203,248797,312743,140381,988829,802831,395251,140381,808439,312743,932951,355457,169987,24767,521393,726469,370879,783487,289111,928793,732601,353677,61463,429469,81119,959809,413087,815273,566441,380729,705883,653243,308437,578041,511213,998857,244129,385057,350029,629417,741071,382663,128173,16273,505907,4129,17291,111721,930113,737147,655847,764627,90059,730571,839071,419281,674717,780233,965927,279731,783661,555091,138451)))
            println(s.gcd(557663, 360169))
        }
    }

    /**
     * 6307. 递枕头
     * https://leetcode.cn/contest/weekly-contest-335/problems/pass-the-pillow/
     */
    fun passThePillow(n: Int, time: Int): Int {
        val last = time % (2*(n - 1))
        return if (last < n) {
            last + 1
        } else {
            2 * n - last - 1
        }
    }

    /**
     * 6308. 二叉树中的第 K 大层和
     * https://leetcode.cn/contest/weekly-contest-335/problems/kth-largest-sum-in-a-binary-tree/
     */
    fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
        if (root == null) {
            return -1
        }
        val list = ArrayList<Long>()
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        while (!queue.isEmpty()) {
            // 遍历每一层的节点，并累加和
            val cnt = queue.size
            var sum = 0L
            for (i in 0 until cnt) {
                val node = queue.pop()
                sum += node.`val`
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
            // 将这一层的节点和添加到列表中
            list.add(sum)
        }
        return if (list.size < k) {
            -1
        } else {
           list.sort()
            list[list.size - k]
        }
    }

    /**
     * 6309. 分割数组使乘积互质
     * https://leetcode.cn/contest/weekly-contest-335/problems/split-the-array-to-make-coprime-products/
     */
    fun findValidSplit(nums: IntArray): Int {
        var lastIndex = 0 // 分割点前的校验点
        var index = 1 // 分割点
        while (index < nums.size && lastIndex < index) {
            // 对每个校验点，不断往后校验，直到某个分割点，可以校验到数组最后，说明分割点不满足, 如果lastIndex 到 index了，那说明index是满足的
            for (i in index until nums.size) {
                if (gcd(nums[lastIndex], nums[i]) != 1) {
                    index = index.coerceAtLeast(i)
                }
            }
            lastIndex++
        }
        return if (index < nums.size - 1) lastIndex else -1
    }

    private fun gcd(num1: Int, num2: Int): Int {
        return if (num2 == 0) {
            num1
        } else {
            gcd(num2, num1 % num2)
        }
    }
}