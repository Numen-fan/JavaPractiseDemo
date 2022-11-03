package com.jiajia.daily;

/**
 * Created by Numen_fan on 2022/11/3
 * Desc: 1668. 最大重复子字符串
 */
public class Solution20221103 {

    public static void main(String[] args) {
        System.out.println(maxRepeating("ababc", "ab"));
    }

    public static int maxRepeating(String sequence, String word) {
        String s = word;
        int i = 0;
        while (sequence.contains(s)) {
            i++;
            s += word;
        }
        return i;
    }

}
