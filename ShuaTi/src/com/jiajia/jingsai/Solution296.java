package com.jiajia.jingsai;

import java.util.*;

/**
 * Created by Numen_fan on 2022/6/5
 * Desc:
 */
public class Solution296 {

    public static void main(String[] args) {

        Solution296 solution296 = new Solution296();

        System.out.println(solution296.minMaxGame(new int[] {1,3,5,2,4,8,2,2}));

        int[] nums = new int[] {3,6,1,2,5};

        System.out.println(solution296.partitionArray(nums, 2));

        int[] arr = new int[] {1,2,4,6};
        int[][] op = new int[][]{{1,3},{4,7},{6,1}};

        solution296.arrayChange(arr, op);

    }

    /**
     * 6090. 极大极小游戏
     * @param nums
     * @return
     */
    public int minMaxGame(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int[] temp = new int[nums.length / 2];


        for (int i = 0; i < temp.length; i++) {
            if (i % 2 == 0) {
                temp[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            } else {
                temp[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
        }
        return minMaxGame(temp);
    }

    /**
     * 6091. 划分数组使最大差为 K
     * @param nums
     * @param k
     * @return
     */
    public int partitionArray(int[] nums, int k) {

        Arrays.sort(nums);

        int start = 0;

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - nums[start] <= k) {
                continue;
            }

            ans++;
            start = i;
        }

        ans++;

        return ans;

    }

    /**
     * 6092. 替换数组中的元素 【超时了】
     * @param nums
     * @param operations
     * @return
     */
    public int[] arrayChange(int[] nums, int[][] operations) {

        // mp[i] -> num[index] = i; // 建立隐射关系
        int[] mp = new int[1000001];

        for (int i = 0; i < nums.length; i++) {
            mp[nums[i]] = i;
        }

        for (int i = 0; i < operations.length; i++) {

            // mp[operations[i][0]] 是operations[i][0]在nums中的下标
            nums[mp[operations[i][0]]] = operations[i][1];

            // 重新建立隐射
            mp[operations[i][1]] = mp[operations[i][0]]; // operations[i][1]这个数的隐射和operations[i][0]相同了。

        }
        return nums;
    }
}
