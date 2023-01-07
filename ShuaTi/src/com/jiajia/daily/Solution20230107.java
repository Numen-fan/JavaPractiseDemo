package com.jiajia.daily;

import com.jiajia.kit.ArrayUtils;

import java.util.Arrays;

/**
 * Created by Numen_fan on 2023/1/7
 * Desc: 1658. 将 x 减到 0 的最小操作数
 */
public class Solution20230107 {

    int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Solution20230107 s = new Solution20230107();
        System.out.println(s.method2(ArrayUtils.string2IntArray("[3,2,20,1,1,3]"),  10));
    }

    public int minOperations(int[] nums, int x) {
        backTracing(nums, 0, nums.length - 1, x);
        return  ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * 递归和回溯【TimeOut了，唉，难受啊】
     * @param nums 操作数组
     * @param start 本层可以操作的左边
     * @param end 本层可以操作的右边
     * @param target 目标数
     */
    private void backTracing(int[] nums, int start, int end, int target) {
        // 递归结束
        if (target == 0) {
            // 已经找到了目标，这个时候可以计算操作次数了,次数为
            ans = Math.min(ans, start + nums.length - 1 - end);
            return;
        }
        // 有效性判断
        if (start > end || target < 0) {
            return;
        }

        // 减去left, 进入下一层
        backTracing(nums, start + 1, end, target - nums[start]);

        // 减去right，进入下一层
        backTracing(nums, start, end - 1, target - nums[end]);
    }

    private int method2(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (sum < x) {
            return -1;
        }

        if (sum == x) {
            return n;
        }

        int ans = n + 1; // 不可能比这个值大
        int lsum = 0, rsum = sum;
        int right = 0;
        for (int left = -1; left < n; left++) {
            if (left != -1) {
                lsum += nums[left]; // 左边和累加
            }

            while (right < n && lsum + rsum > x) {
                rsum -= nums[right];
                right++;
            }

            if (lsum + rsum == x) {
                ans = Math.min(ans, left + 1 + n - right);
            }
        }

        return ans > n ? -1 : ans;
    }

}
