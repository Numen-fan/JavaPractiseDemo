package com.jiajia.daily

class Solution20230318 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution20230318()
            println(s.checkPalindromeFormation("ulacfd", "jizalu"))
        }
    }

    fun checkPalindromeFormation(a: String, b: String): Boolean {
        return check(a, b) || check(b, a)
    }

    private fun check(a: String, b: String): Boolean {
        // 找到a的prefix和b的suffix
        var i = 0
        var j = a.length - 1
        while (i < j && a[i] == b[j]) {
            i++
            j--
        }
        return isPalindrome(a, i, j) || isPalindrome(b, i, j)
    }

    /**
     * 判断s从i到j是否是回文
     */
    private fun isPalindrome(str: String, left: Int, right: Int): Boolean {
        var i = left
        var j = right
        while (i < j && str[i] == str[j]) {
            i++
            j--
        }
        return i >= j
    }
}