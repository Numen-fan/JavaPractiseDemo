package com.jiajia.hard;

import java.util.Arrays;

/**
 * Created by Numen_fan on 2022/6/12
 * Desc: 1723. 完成所有工作的最短时间
 * 代码参考 ： 5289. 公平分发饼干
 */
public class MinimumTimeRequired1723 {
    int ans = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs); // 从下到大进行排序

        method(jobs, k, new int[k], jobs.length - 1);

        return ans;

    }

    public void method(int[] jobs, int k, int[] bucket, int start) {

        // 说明走到最后了，查找这一轮的结果
        if (start < 0) {
            int tempAns = Integer.MIN_VALUE;
            for (int count : bucket) {
                tempAns = Math.max(count, tempAns);
            }
            ans = Math.min(ans, tempAns);
            return;
        }

        // 剪枝1，如果空手的数量大于剩余的饼干数量，则直接返回
        int zeroCount = 0;
        for (int count : bucket) {
            zeroCount += count == 0 ? 1 : 0;
        }

        if (zeroCount > start + 1) { // start参数是从后往前，所以还剩余start + 1个饼干
            return;
        }

        // 剪枝2 如果某个孩子的饼干数量已经超过当前记录的结果值，则也没必要再继续下去了
        for (int count : bucket) {
            if (count >= ans) {
                return;
            }
        }

        // 相当于将每个饼干都尝试分配给其中一个同学，然后，默认将第一个饼干分给第一个同学。这样可以保证只有一颗分配树
        for (int i = 0; i < k; i++) {

            // 剪枝3 第一包零食默认分给第一个同学，即i=0 ？？？？
            if (start == jobs.length - 1 && i > 0) {
                return;
            }

            bucket[i] += jobs[start];
            method(jobs, k, bucket, start - 1);

            //回溯，去掉本次分配
            bucket[i] -= jobs[start];
        }
    }


}
