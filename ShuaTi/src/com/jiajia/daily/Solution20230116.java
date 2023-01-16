package com.jiajia.daily;

/**
 * Created by Numen_fan on 2023/1/16
 * Desc: https://leetcode.cn/problems/sentence-similarity-iii/  1813. 句子相似性 III
 */
public class Solution20230116 {

    public static void main(String[] args) {
        Solution20230116 s = new Solution20230116();
        System.out.println(s.areSentencesSimilar("qbaVXO Msgr aEWD v ekcb", "Msgr aEWD ekcb"));
    }

    /**
     * 自己写得真的烂，还是应该看看官方的解答，真的写的很好，唉
     * https://leetcode.cn/problems/sentence-similarity-iii/solutions/2062566/ju-zi-xiang-si-xing-iii-by-leetcode-solu-vjy7/
     * @param sentence1
     * @param sentence2
     * @return
     */
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence2.equals(sentence1)) {
            return true;
        }

        if (sentence1.length() == sentence2.length()) {
            return false; // 如果长度相等，当时却内容不同，则肯定么办法操作的
        }

        String shortStr, longStr;
        if (sentence1.length() > sentence2.length()) {
            longStr = sentence1;
            shortStr = sentence2;
        } else {
            longStr = sentence2;
            shortStr = sentence1;
        }

        if (longStr.startsWith(shortStr)) {
            // 首尾的情况
            int shortLen = shortStr.length();
            if ( longStr.charAt(shortLen) == ' ') {
                return true;
            }
        }

        if (longStr.endsWith(shortStr)) {
            int shortLen = shortStr.length();
            return longStr.charAt(longStr.length() - shortLen - 1) == ' ';
        }

        if (longStr.contains(shortStr)) {
            // 在长句中间，那么不可能通过插入完成句子组装
            return false;
        }

        // 现在考虑需要在短句子中间插入的情况了
        // 这种情况，一定是长短句的前面和后面要相同
        // 输入：sentence1 = "My name is Haley", sentence2 = "My Haley"
        int left = 0, right = shortStr.length() - 1;
        while (left < right && shortStr.charAt(left) == longStr.charAt(left)) {
            left++;
        }

        // 长短句中的left已经不相同了
        left--;
        if (left < 0 || longStr.charAt(left) != ' ') {
            return false; // 不在单词中间断开
        }

        int lRight = longStr.length() - 1;
        while (left <= right && shortStr.charAt(right) == longStr.charAt(lRight)) {
            right--;
            lRight--;
        }

        // 长短句中的right已经不相同了
        lRight++;
        right++;
        if (lRight >= longStr.length() || longStr.charAt(lRight) != ' ') {
            return false;
        }

        return left == right;
    }

}
