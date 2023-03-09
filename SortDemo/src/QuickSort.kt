class QuickSort {

    /**
     * 先实现快排
     */
    private fun quickSort(nums: IntArray, left: Int, right: Int) {
        if (left >= right) {
            return
        }

        val pivot = nums[left] // 最左边的基准元素
        var i = left // 左指针 // 左边位置空了
        var j = right // 右指针
        while (i < j) {
            // 先在右边找到比pivot小的元素
            while (j > i && nums[j] >= pivot) {
                j--
            }
            if (j > i) {
                nums[i] = nums[j]
                // 继续从左往右找到第一个大于pivot的元素
                while (j > i && nums[i] < pivot) {
                    i++
                }
                if (i < j) {
                    nums[j] = nums[i]
                }
            }
        }

        // i==j
        nums[i] = pivot // 基准元素落位， 这个地方就知道了i位置了
        // 继续左右元素的位置
        quickSort(nums, left, i)
        quickSort(nums, i + 1, right)
    }

}