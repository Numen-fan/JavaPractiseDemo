package com.jiajia.daily;

public class Solution20221228 {

    public static void main(String[] args) {
        Solution20221228 s = new Solution20221228();
        System.out.println(s.minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }

    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            char a = s.charAt(left);

            while (left <= right && s.charAt(left) == a) {
                left++;
            }

            while (right >= left && s.charAt(right) == a) {
                right--;
            }
        }

        return right - left + 1;
    }

}
