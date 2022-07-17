package com.jiajia.daily;

/**
 * Created by Numen_fan on 2022/7/11
 * Desc:
 */
public class Solution20220711 {

    public static void main(String[] args) {
        String[] dict = new String[]{"hello","hallo","leetcode","judge"};
        System.out.println(search(dict, "juage"));
    }


    public static boolean search(String[] dict, String searchWord) {
        if (dict == null || dict.length == 0) {
            return false;
        }

        for (String word : dict) {
            if (word.length() != searchWord.length() || word.equals(searchWord)) {
                continue;
            }

            // 找到了长度相等，并且不equals的字符串
            int diff = 0;
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == searchWord.charAt(j)) {
                    continue;
                }
                diff++;
            }
            if (diff == 1) { // 找到了
                return true;
            }
        }
        return false;
    }

}
