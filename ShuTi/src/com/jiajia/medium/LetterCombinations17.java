package com.jiajia.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations17 {

    private static final List<String> result = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        System.out.println(letterCombinations("23"));

    }

    public static List<String> letterCombinations(String digits) {
        return blockTracing(digits, 0);
    }

    /**
     * 注意用startIndex避免进行字符串的subString
     * @param startIndex 本次开始的下标位置
     */
    private static List<String> blockTracing(String digits, int startIndex) {
        // 退出递归条件
        if (startIndex == digits.length()) {
            if (sb.length() > 0) {
                result.add(sb.toString());
            }
            return result; // 这return 是退出本次递归而已
        }

        String str = getStringByNum(digits.charAt(startIndex) - '0');
        for (int j = 0; j < str.length(); j++) {
            sb.append(str.charAt(j));
            // 进入下一个数字循环
            blockTracing(digits, startIndex + 1);
            // 回溯处理，将当前的append的字符remove 【这里只关心本层递归所做的事，不需要考虑在上面的递归中做了append，因为在它所属的那一层已经做了回溯处理】
            String strTmp = sb.toString();
            sb = new StringBuilder(strTmp.substring(0, strTmp.length() - 1));
        }

        return result;
    }

    private static String getStringByNum(int num) {
        int len = num == 9 || num == 7 ? 4 :3;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append((char)('a' + ((num - 2) * 3  + (num > 7 ? i + 1 : i))));
        }
        return sb.toString();
    }
}
