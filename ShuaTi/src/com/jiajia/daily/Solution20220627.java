package com.jiajia.daily;

public class Solution20220627 {

    public static void main(String[] args) {
        Solution20220627 solution20220627 = new Solution20220627();
        System.out.println(solution20220627.findLUSlength(new String[] {"aabbcc", "aabbcc","cb"}));
    }

    // 在字符串数组中找到一个字符串，使得该字符串不是其它字符串的子串，这个字符串称为特殊序列，返回最长特殊序列的长度
    public int findLUSlength(String[] strs) {

        int ans = -1;

        for (int i = 0; i < strs.length; i++) { // 找strs[i] 是否是特殊子串序列
            boolean find = false; // 标记strs[i]是否匹配上子串
            for(int j = 0; j < strs.length; j++) {
                if(j == i) {
                    continue;
                }
                if (dfs(strs[i], strs[j], 0, 0)) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                ans = Math.max(ans, strs[i].length());
            }
        }

        return ans;
    }

    /**
     * 判断str1从index1开始是不是str2从index2开始的子串
     * @param str1
     * @param str2
     * @param index1
     * @param index2
     * @return
     */
    private boolean dfs(String str1, String str2, int index1, int index2) {

        if (str1.equals(str2) || index1 >= str1.length()) {
            return true;
        }

        for (int i = index2; i < str2.length(); i++) {
            if (str1.charAt(index1) == str2.charAt(i)) {
                return dfs(str1, str2, index1 + 1, i + 1);
            }
        }

        return false;
    }

}
