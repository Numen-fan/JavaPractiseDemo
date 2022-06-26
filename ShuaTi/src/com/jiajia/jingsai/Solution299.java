package com.jiajia.jingsai;

/**
 * Created by Numen_fan on 2022/6/26
 * Desc:
 */
public class Solution299 {

    public static void main(String[] args) {
        Solution299 solution299 = new Solution299();

        System.out.println(solution299.countHousePlacements(1000));
    }

    /**
     * 6101. 判断矩阵是否是一个 X 矩阵
     */
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || j == n - 1 - i) { // 对角线上的元素
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else if (grid[i][j] != 0) { // 非对角线的元素
                    return false;
                }
            }

//        int tempSum = 0;
//
//        /**
//         * 遍历对角线
//         */
//        for (int i = 0; i < n; i++) {
//            // 左对角
//            if (grid[i][i] == 0) {
//                return false;
//            }
//            tempSum += grid[i][i];
//
//            if (i == n - i - 1) {
//                continue;
//            }
//
//
//            // 右边对角
//            if(grid[i][n - i - 1] == 0) {
//                return false;
//            }
//
//            tempSum += grid[i][n - i - 1];
//
//        }
//
//        return sum == tempSum;

        }

        return true;

    }


    /**
     * 6100. 统计放置房子的方式数
     */
    public int countHousePlacements(int n) {

        double[][] dp = new double[n][4];

        double m = 1000000007;

        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[0][3] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3])  % m;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2])  % m;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1])  % m;
            dp[i][3] = dp[i - 1][0]  % m;
        }

        return (int) ((dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2] + dp[n - 1][3]) % m);


    }

    /**
     * 5229. 拼接数组的最大分数
     * @param nums1
     * @param nums2
     * @return
     */
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {

        int[] f = new int[nums1.length];
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < nums1.length; i++) {
            f[i] = nums2[i] - nums1[i];
            sum1 += nums1[i];
        }

        sum1 += gao(f);

        for (int i = 0; i < nums1.length; i++) {
            f[i] = nums1[i] - nums2[i];
            sum2 += nums2[i];
        }

        sum2 += gao(f);

        return Math.max(sum1, sum2);
    }

    public int gao(int[] arr) {
        int now = 0; int ans = 0;
        for (int a : arr) {
            now += a;
            if (now < 0) {
                now = 0;
            }
            ans = Math.max(ans, now);
        }

        return ans;
    }
}