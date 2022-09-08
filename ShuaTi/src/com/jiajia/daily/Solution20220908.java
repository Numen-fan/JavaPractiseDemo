package com.jiajia.daily;

import com.jiajia.kit.ArrayUtils;

/**
 *  [667] 优美的排列 II
 *  思想：https://leetcode.cn/problems/beautiful-arrangement-ii/solution/you-by-capital-worker-rnwi/
 */
public class Solution20220908 {

    public static void main(String[] args) {
        ArrayUtils.print(constructArray(3, 1));
    }

    public static int[] constructArray(int n, int k) {

       int[] ans = new int[n];

       int l = 1, r = n; // l从小到大，r从大到小

        int i = 0; // 数组遍历下标

        // 先取前k个数，构造k-1个不同的差, 奇数下标取较小的数，偶数下标取较大的数
        for(int j = 0; j < k; j++) {
            ans[i] = i % 2 == 0 ? l++ : r--;
            i++;
        }

        // 处理剩下差为1的情况，如果k是偶数，那么前面ans[i]是较大的数，因此后面的数从大到小
        // 反之，如果后面的数是从小到大
        if (k % 2 == 0) {
            while (i < n) {
                ans[i++] = r--;
            }
        } else {
            while (i < n) {
                ans[i++] = l++;
            }
        }
        return ans;

    }
}
