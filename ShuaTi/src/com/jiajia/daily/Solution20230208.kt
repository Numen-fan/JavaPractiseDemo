package com.jiajia.daily

/**
 * 1233. 删除子文件夹
 */
class Solution20230208 {
    fun removeSubfolders(folder: Array<String>): List<String> {
        // 按照目录的长度进行排序
//        folder.sortWith { s1: String, s2: String -> s1.length - s2.length }
        folder.sortBy { it.length }
        val childFolderIndex = ArrayList<Int>()
        for (i in 1 until folder.size) {
            for (j in 0 until i) {
                // 查看[0 - (i - 1)]是否有i的父目录
                if (isParentFolder(folder[j], folder[i])) {
                    childFolderIndex.add(i) // 标记i是一个子目录，并退出
                    break
                }
            }
        }
        return folder.filterIndexed { index, _ -> !childFolderIndex.contains(index) }
    }

    private fun isParentFolder(parent: String, child: String): Boolean {
        if (!child.startsWith(parent)) {
            return false
        }
        return child[parent.length] == '/'
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230208()
            println(s.removeSubfolders(listOf("/a", "/a/b", "/c/d", "/c/d/e", "/c/f").toTypedArray()))
        }
    }
}