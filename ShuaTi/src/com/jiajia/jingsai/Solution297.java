package com.jiajia.jingsai;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Created by Numen_fan on 2022/6/12
 * Desc:
 */
public class Solution297 {

    public static void main(String[] args) {
        Solution297 solution297 = new Solution297();

        System.out.println(solution297.calculateTax(new int[][]{{3,50},{7,10},{12,25}}, 10));

        System.out.println(solution297.distributeCookies(new int[]{8,15,10,20,8}, 2));
    }

    /**
     * 5259. 计算应缴税款总额
     * @param brackets
     * @param income
     * @return
     */
    public double calculateTax(int[][] brackets, int income) {
        double res = 0;

        if (income <= 0) {
            return 0;
        }
        int last = 0;
        for (int[] arr : brackets) {
            int temp = arr[0] - last;
            if (income >= temp) {
                income -= temp;
                res += temp * arr[1] / 100f;
            } else {
                res += income * arr[1] / 100f;
                income = 0;
            }
            last = arr[0];

            if (income == 0) {
                break;
            }
        }

        DecimalFormat df = new DecimalFormat("#.00");
        return Double.parseDouble(df.format(res));
    }

    /**
     * 5270. 网格中的最小路径代价
     * @param grid
     * @param moveCost
     * @return
     */
    public int minPathCost(int[][] grid, int[][] moveCost) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n]; // dp[i][j] 表示到第i行j列最小的代价

        // 初始化第一行
        System.arraycopy(grid[0], 0, dp[0], 0, n);

        // 开始动态规划
        for (int i = 1; i < m; i++) { // 控制行
            for (int j = 0; j < n; j++) { // 控制列
                dp[i][j] = Integer.MAX_VALUE;
                // i，j这点由上层最小节点过来
                for (int k = 0; k < n; k++) {
                    dp[i][j] = Math.min(dp[i][j], grid[i][j] + dp[i - 1][k] + moveCost[grid[i - 1][k]][j]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[m - 1][j]);
        }

        return ans;
    }

    /**
     * 5289. 公平分发饼干
     * 使递归+回溯方法
     * @param cookies
     * @param k
     * @return
     */

    int ans = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {

        Arrays.sort(cookies); // 从下到大进行排序

        method(cookies, k, new int[k], cookies.length - 1);

        return ans;
    }

    public void method(int[] cookies, int k, int[] bucket, int start) {

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

        for (int i = 0; i < k; i++) {

            // 剪枝3 第一包零食默认分给第一个同学，即i=0 ？？？？
            if (start == cookies.length - 1 && i > 0) {
                return;
            }

            bucket[i] += cookies[start];
            method(cookies, k, bucket, start - 1);

            //回溯，去掉本次分配
            bucket[i] -= cookies[start];
        }
    }
}
