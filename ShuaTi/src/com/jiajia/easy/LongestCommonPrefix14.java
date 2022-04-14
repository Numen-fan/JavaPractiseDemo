package com.jiajia.easy;

/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

public class LongestCommonPrefix14 {

    public static void main(String[] args) {
        String[] strs = {"", ""};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }

        int minLength = 201;
        String minLenStr = "";

        // 找到数组中最短串
        for(String str : strs) {
            if(str.length() < minLength) {
                minLength = str.length();
                minLenStr = str;
            }
        }

        if (minLength == 0) { // case ["", ""]
            return "";
        }

        // method 1
        // return findCommonPrefix1(minLenStr, strs);

        // method 2
        StringBuilder result = new StringBuilder();
        result = findCommonPrefix2(result, minLenStr, strs);
        return result.toString();
    }

    /**
     依次取最短串的子串进行匹配
     */
    private static String findCommonPrefix1(String minLenStr, String[] strs) {
        String lastSubStr = ""; // 标记前一个子串
        for(int subLen = 1; subLen <= minLenStr.length(); subLen++) {
            String subStr = minLenStr.substring(0, subLen);
            if(isSubStringMatch(subStr, strs)) {
                lastSubStr = subStr;
            } else {
                break;
            }
        }
        return lastSubStr;
    }

    /**
     可以优化一下，先来个二分查找，前缀子串只会是前缀，因此每次折半取左边一半
     如果左边一半匹配，再拆分右边的一半子串。
     如果左边不匹配，则拆分左边的一半子串
     */
    private static StringBuilder findCommonPrefix2(StringBuilder result, String targetStr, String[] strs) {
        if(targetStr.length() == 0) { // 兜底
            return result;
        }

        if (targetStr.length() == 1) {
            return isSubStringMatch(result.toString() + targetStr, strs) ? result.append(targetStr) : result;
        }

        int length = targetStr.length();
        String leftStr = targetStr.substring(0, length / 2);
        String rightStr = targetStr.substring(length / 2, length);
        if(isSubStringMatch(result.toString() + leftStr, strs)) {
            return findCommonPrefix2(result.append(leftStr), rightStr, strs);
        } else {
            return findCommonPrefix2(result, leftStr, strs);
        }
    }

    /**
     * 判断subStr是否是字符串数组strs的前缀子串
     */
    private static boolean isSubStringMatch(String subStr, String[] strs) {
        for(String str : strs) {
            if(str.startsWith(subStr)) {
                continue;
            }
            return false;
        }
        return true;
    }
}
