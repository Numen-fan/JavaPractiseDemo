package com.jiajia.medium;

public class FindLength718 {

    public static void main(String[] args) {
        System.out.println(dpMethod(new int[]{1,2,3,2,8}, new int[] {5,6,1,4,7}));
    }


    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private static int dpMethod(int[] nums1, int[] nums2) {

        // dp[i][j]表示i-1，j-1的最长重复子数组长度。
        // dp[i][j]的取值，如果A[i - 1] == B[j - 1]相等，那么dp[i][j] = dp[i - 1][j - 1] + 1

        int[][] dp = new int[nums1.length][nums2.length];

        int ans = 0;

        // for (int i = 1; i <= nums1.length; i++) {
        //     for (int j = 1; j <= nums2.length; j++) {
        //         if (nums1[i - 1] == nums2[j - 1]) {
        //             dp[i][j] = dp[i - 1][j - 1] + 1;
        //         }
        //         ans = Math.max(ans, dp[i][j]);
        //     }
        // }


        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
                ans = 1;
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == nums1[0]) {
                dp[0][i] = 1;
                ans = 1;
            }
        }

        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }


        return ans;
    }

}
