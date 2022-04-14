package com.jiajia.easy;

import java.util.Arrays;

public class LargestSumAfterKNegations1005 {

    public static void main(String[] args) {
        System.out.println(method1(new int[]{5,6,9,-3,3}, 2));
    }

    static int method1(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums[0] >= 0) { // 排序后，首位非负数
            if (k % 2 == 0) {
                return addArrays(nums);
            } else {
                return addArrays(nums) - 2 * nums[0];
            }
        }

        // 首位有负数，将最小的负数取反
        int i = 0;
        for(; i < nums.length && i < k; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
            } else {
                break; // 说明后面非负数
            }
        }

        if (i >= k) { // 说明已经k次已经调整完毕
            return addArrays(nums);
        }

        // 调整了i次，注意这里，上面退出循环，说明i不满足条件了，因此调整了i次（下标从0开始的）
        // 剩余 k - i 次需要调整
        // 取num[i] 和num[i - 1]进行反复取反操作，注意i可能已经超出了数组长度
        int target = i > nums.length - 1 ? nums[i - 1] : Math.min(nums[i], nums[i - 1]);
        return addArrays(nums) - ((k - i) % 2 != 0 ? 2 * target : 0);
    }

    static int addArrays(int[] nums) {
        int ans = 0;
        for(int num : nums) {
            ans += num;
        }
        return ans;
    }

}
