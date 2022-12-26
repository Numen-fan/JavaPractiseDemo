package com.jiajia.daily;

import com.jiajia.kit.ArrayUtils;

/**
 * Created by Numen_fan on 2022/12/17
 * Desc: 1764. 通过连接另一个数组的子数组得到一个数组
 * https://leetcode.cn/problems/form-array-by-concatenating-subarrays-of-another-array/
 */
public class Solution20221217 {

    public static void main(String[] args) {
        Solution20221217 solution20221217 = new Solution20221217();

        System.out.println(solution20221217.canChoose(ArrayUtils.string2IntArray2("[[1,-1,-1],[3,-2,0]]"),
                ArrayUtils.string2IntArray("[1,-1,0,1,-1,-1,3,-2,0]")));
    }

    public boolean canChoose(int[][] groups, int[] nums) {
        int start = 0; // 遍历nums数组的下标
        for (int[] arr : groups) {
            // 从start开始查找arr相匹配的子树组
            start = isMatch(arr, nums, start);
            if (start == -1) {
                return false;
            }
        }
        return true;
    }

    private int isMatch(int[] arr, int[] nums, int start) {
        int len = nums.length;
        for (int i = start; i < nums.length; i++) { // 从 i 这个起点开始
            if (len - i < arr.length) {
                return -1; // 不可能满足
            }

            int j = 0;
            int k = i;

            while (j < arr.length && k < nums.length && arr[j] == nums[k]) {
                j++;
                k++;
            }

            if (j == arr.length) {
                return k;
            }
        }

        return -1;
    }

}
