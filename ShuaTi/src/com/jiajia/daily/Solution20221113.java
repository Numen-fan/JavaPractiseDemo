package com.jiajia.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Numen_fan on 2022/11/13
 * Desc: 791. 自定义字符串排序
 */
public class Solution20221113 {

    public static void main(String[] args) {
        System.out.println(customSortString("kqep", "pekeq"));
    }

    // 先将order进行处理，由于order中每个字符都是不重复的，因此可以看做26个字母的排序
    // 使用数组记录字母a-z出现的顺序，比如order[c] = 0，表示c在第一位。
    // 然后申请s长度的字符数组，依次遍历每一位
    // 从order中检索出开始的位置，从开始的位置向后查找插入的位置即可。
    public static String customSortString(String order, String s) {
        int n = s.length();
        char[] chs = new char[n];
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            int cnt = map.getOrDefault(ch, 0);
            map.put(ch, cnt + 1);
        }

        int index = 0;
        for (char ch : order.toCharArray()) {
            int cnt = map.getOrDefault(ch, 0);
            if (cnt == 0) {
                continue; // s 中不含有字符ch
            }

            while (cnt > 0) {
                chs[index++] = ch;
                cnt--;
            }

            map.remove(ch);

        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue();
            while (cnt > 0) {
                chs[index++] = entry.getKey();
                cnt--;
            }
        }

        return String.valueOf(chs);
    }

}
