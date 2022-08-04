package com.jiajia.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution20220804 {

    public static void main(String[] args) {

        int[] a = new int[10000000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        long before = System.currentTimeMillis();

        Arrays.stream(a).sum();

        long after = System.currentTimeMillis();

        System.out.println("stream " + (after - before));

        long before1 = System.currentTimeMillis();

        int cnt = 0;
        for(int i = 0; i < a.length; i++) {
            cnt += a[i];
        }

        long after1 = System.currentTimeMillis();

        System.out.println("for " + (after1 - before1));


        minSubsequence(new int[]{4,3,10,9,8});

    }

    public static List<Integer> minSubsequence(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        int cnt = Arrays.stream(nums).sum();

        int subCnt = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            subCnt += nums[i]; // 尝试将nums[i]加入序列
            ans.add(nums[i]);
            if (subCnt > cnt - subCnt) {
                break;
            }
        }

        return ans;
    }
}
