package com.jiajia.daily;

import java.util.Arrays;

/**
 * 1592. 重新排列单词间的空格
 */
public class Solution20220907 {

    public static void main(String[] args) {
        System.out.println(reorderSpaces("  this   is  a sentence "));
    }


    public static String reorderSpaces(String text) {

        int backspaceCnt = 0; // 统计出空格的个数

        for (char ch : text.toCharArray()) {
            if (ch == ' ') {
                backspaceCnt++;
            }
        }

        String[] words = text.trim().split("[ ]+"); // 通过空格拆分单词

        int interval = words.length > 1 ? backspaceCnt / (words.length - 1) : backspaceCnt; // 每两个单词之间的空格数, 注意这里的除数可能为0

        StringBuilder sb = new StringBuilder();

        char[] spaces = new char[interval];
        Arrays.fill(spaces, ' ');
        String space = String.valueOf(spaces);

        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i != words.length - 1) {
                sb.append(space);
                backspaceCnt -= interval;
            }
        }

        while(backspaceCnt-- > 0) {
            sb.append(" ");
        }

        return sb.toString();

    }


}
