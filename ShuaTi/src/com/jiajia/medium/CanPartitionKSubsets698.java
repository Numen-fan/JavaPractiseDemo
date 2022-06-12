package com.jiajia.medium;

import java.util.Arrays;

/**
 * Created by Numen_fan on 2022/6/12
 * Desc: 698. 划分为k个相等的子集
 * 参考 5289. 公平分发饼干 、 1723. 完成所有工作的最短时间
 */
public class CanPartitionKSubsets698 {

    public static void main(String[] args) {
        CanPartitionKSubsets698 canPartitionKSubsets698 = new CanPartitionKSubsets698();
        System.out.println(canPartitionKSubsets698.canPartitionKSubsets(new int[]{3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,2695}, 5));
    }

    int everyCount = 0;
    public boolean canPartitionKSubsets(int[] nums, int k) {

        Arrays.sort(nums); // 从下到大进行排序

        int sum  = 0;

        for (int num: nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        everyCount = sum / k;

        return method(nums, k, new int[k], nums.length - 1);

    }

    public boolean method(int[] nums, int k, int[] bucket, int start) {
        // 说明走到最后了，判断以下此轮的分配是否均匀
        if (start < 0) {
            int ans = bucket[0];
            for (int count : bucket) {
                if (count != ans) {
                    return false;
                }
            }

            return true; // 找到了
        }

        // 剪枝1，如果空手的数量大于剩余的饼干数量，则直接返回
        int zeroCount = 0;
        for (int count : bucket) {
            zeroCount += count == 0 ? 1 : 0;
            if (count > everyCount) {
                return false;
            }
        }

        if (zeroCount > start + 1) { // start参数是从后往前，所以还剩余start + 1个饼干
            return false;
        }

        for (int i = 0; i < k; i++) {

            // 剪枝3 第一包零食默认分给第一个同学，即i=0 ？？？？【这一步很关键，否则就超时了】
            if (start == nums.length - 1 && i > 0) {
                return false;
            }

            bucket[i] += nums[start];
            if (method(nums, k, bucket, start - 1)) {
                return true; // 找到了，则直接返回了
            }

            //回溯，去掉本次分配
            bucket[i] -= nums[start];
        }

        // 找到最后没找到
        return false;
    }



}
