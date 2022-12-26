package com.jiajia.daily;

/**
 * Created by Numen_fan on 2022/12/24
 * Desc:
 */
public class Solution20221224 {

    public static void main(String[] args) {
        Solution20221224 s = new Solution20221224();
        System.out.println(s.largestMerge("cabaa", "bcaaa"));
    }

    public String largestMerge(String word1, String word2) {

        // error
//        StringBuilder sb = new StringBuilder(word1);
//        int index = 0; // 插入位置
//        for(int i = 0; i < word2.length(); i++) {
//            char c = word2.charAt(i);
//            while (index < sb.length() && sb.charAt(index) >= c) {
//                index++;
//            }
//            sb.insert(index, c);
//            index++;
//        }
//
//        return sb.toString();

        // bingo
        StringBuilder merge = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length() && word1.substring(i).compareTo(word2.substring(j)) > 0) {
                merge.append(word1.charAt(i));
                i++;
            } else {
                merge.append(word2.charAt(j));
                j++;
            }
        }
        return merge.toString();


    }
}
