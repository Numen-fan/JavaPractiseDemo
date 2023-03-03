package com.jiajia.jianzhioffer

/**
 *剑指 Offer 51. 数组中的逆序对
 */
class Offer51Important {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = Offer51Important()
            println(o.reversePairs(intArrayOf(7,5,6,4)))
        }
    }

    fun reversePairs(nums: IntArray): Int {
        if (nums.size < 2) {
            return 0 // 不存在数对
        }
        val temp = IntArray(nums.size) // 辅助数组
        return sort(nums, 0, nums.size - 1, temp)
    }

    /**
     * 归并排序两个left到right取区间
     */
    private fun sort(nums: IntArray, left: Int, right: Int, temp: IntArray): Int {
        if (left == right) { // 左右移动到相同位置上了
            return 0
        }
        val mid = left + (right - left) / 2; // 这里二分查找容易出错，当left和right很大的时候，可能出现整数溢出的问题，所以不能使用（left + right）/ 2
        val leftPairs = sort(nums, left, mid, temp)
        val rightPairs = sort(nums, mid + 1, right, temp)
        if (nums[mid] < nums[mid + 1]) { // 左右已经有序了，不需要再合并了
            return leftPairs + rightPairs
        }
        // 接下来进行合并
        val mergePairs = merge(nums, left, mid, right, temp)
        return mergePairs + leftPairs + rightPairs
    }

    /**
     * 合并nums[left~mid]和nums[mid+1~right]这两个有序序列
     */
    private fun merge(nums: IntArray, left: Int, mid: Int, right: Int, temp: IntArray): Int {
        // 先要进行一次数组的拷贝
        for (i in left..right) {
            temp[i] = nums[i]
        }
        var i = left // 左边部分的下标
        var j = mid + 1 // 右边部分的下标
        var count = 0
        for (k in left..right) {
            if (i == mid + 1) { // 要注意这里的+1，因为是先放置
                // 左边已经合并完了，那就直接放右边的元素
                nums[k] = temp[j]
                j++
            } else if (j == right + 1) { // 要注意这里的+1
                // 右边已经放完了，直接放左边
                nums[k] = temp[i]
                i++
            }else if (temp[i] <= temp[j]) { // 注意如果相等，则优先将left的元素归位
                nums[k] = temp[i]
                i++
            } else {
                nums[k] = temp[j]
                j++
                // 出现了逆序
                count += (mid - i + 1)
            }
        }
        return count
    }
}