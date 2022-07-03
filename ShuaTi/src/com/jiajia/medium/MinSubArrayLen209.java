package com.jiajia.medium;

/**
 * Created by Numen_fan on 2022/7/2
 * Desc:
 */
public class MinSubArrayLen209 {

    public static void main(String[] args) {

        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));

    }

    public static int minSubArrayLen(int target, int[] nums) {

        // 经典的滑动窗口题目

        int left = 0; // 这样才能保证

        int ans = nums.length + 1;
        int sum = 0; // 滑动窗口中的值

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (sum == target) {
                // 滑动窗口中的和刚好 = target
                ans = Math.min(ans, i - left + 1);
            } else if (sum > target) {
                // 滑动窗口中的和超过了target
                // 这时候，移动左边窗口
                while(sum >= target && left <= i) {
                    ans = Math.min(ans,  i - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }
        }

        return ans == nums.length + 1 ? 0 : ans;
    }

}
