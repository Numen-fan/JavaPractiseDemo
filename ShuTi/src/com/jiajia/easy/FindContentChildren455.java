package com.jiajia.easy;

import java.util.Arrays;

public class FindContentChildren455 {

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
    }

    public static int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int sBeginIndex = 0;
        for (int k : g) {
            for (int j = sBeginIndex; j < s.length; ) {
                if (s[j] >= k) {
                    count++;
                    sBeginIndex = j + 1;
                    break;
                }
                j++;
            }

            if (sBeginIndex >= s.length) {
                break;
            }
        }
        return count;
    }
}
