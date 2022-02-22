package com.jiajia.jingsai;

import java.util.Arrays;

public class Solution255 {

    /**
     * 5850. 找出数组的最大公约数
     */
    public int findGCD(int[] nums) {
        Arrays.sort(nums); // 排序
        int minNum = nums[0];
        int maxNum = nums[nums.length - 1];
        for (int i = minNum; i > 0 ; i--) {
            if (minNum % i == 0 && maxNum % i == 0) {
                return i;
            }
        }
        return 1;
    }

    /**
     * 5851. 找出不同的二进制字符串
     */
    public static String findDifferentBinaryString(String[] nums) {
        if (nums.length == 1) {
            return "1".equals(nums[0]) ? "0" : "1";
        }

        int res = 0;
        for (String num : nums) {
            int temp = Integer.parseInt(num, 2);
            res = res ^ temp;
        }
        String resStr = Integer.toBinaryString(res);
        if (resStr.length() < nums.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length - resStr.length(); i++) {
                sb.append("0");
            }
            sb.append(resStr);
            resStr = sb.toString();
        }

        int i = 0;
        String tmp = resStr;
        while (contains(nums, resStr) && i < resStr.length()) {
            resStr = (tmp.charAt(i++) == '1' ? "0" : "1") + tmp.substring(1);
        }
        if(contains(nums, resStr)) {
            resStr = resStr.substring(0, resStr.length() - 1) + (resStr.charAt(resStr.length() - 1) == '0' ? "1" : "0");
        }
        return resStr;
    }

    private static boolean contains(String[] nums, String target) {
        for (String str : nums) {
            if (target.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] nums = {"0110","0011","0101","1101"};
        System.out.println(findDifferentBinaryString(nums));
    }

}
