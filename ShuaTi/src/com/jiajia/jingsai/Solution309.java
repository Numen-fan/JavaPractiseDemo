package com.jiajia.jingsai;

import com.jiajia.kit.ArrayUtils;

import java.util.Arrays;

/**
 * Created by Numen_fan on 2022/9/4
 * Desc:
 */
public class Solution309 {

    public static void main(String[] args) {

        System.out.println(longestNiceSubarray(ArrayUtils.string2IntArray("[1,3,8,48,10]")));


        System.out.println(numberOfWays(1, 2, 3));

    }

    /**
     * 6167. 检查相同字母间的距离
     * @param s
     * @param distance
     * @return
     */
    public boolean checkDistances(String s, int[] distance) {

        int[] index = new int[26]; // 记录a-z第一次出现的下标
        Arrays.fill(index, -1);
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (index[a - 'a'] == -1) {
                index[a - 'a'] = i;
            } else {
                // 第二次出现
                if (i - index[a - 'a'] - 1 != distance[a - 'a']) {
                    return false;
                }
            }
        }
        return true;
    }


    static int ans = 0;

    /**
     * 6168. 恰好移动 k 步到达某一位置的方法数目
     * @param startPos
     * @param endPos
     * @param k
     * @return
     */
    public static int numberOfWays(int startPos, int endPos, int k) {

        int mod = (int) 1e9 + 7;

        long[][] dp = new long[2005][1005]; // dp[i][j] 走到i位置花费j步的方案数,由于有负数，所以整体+1000，转为正数

        // 初始化
        dp[1000 + startPos + 1][1] = 1;
        dp[1000 + startPos - 1][1] = 1;

        for (int i = 2; i <= k; i++) {
            for (int j = 1000 + startPos - k; j <= 1000 + startPos + k; j++) {
                dp[j][i] = (dp[j - 1][i - 1] + dp[j + 1][i - 1]) % mod;
            }
        }

        return (int)dp[endPos + 1000][k];



    }

    /**
     * 6169. 最长优雅子数组
     * @param nums
     * @return
     */
    public static int longestNiceSubarray(int[] nums) {

        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            // 起点i
            int len = getLen(nums, i, nums.length - 1);
            if (len == 0) {
                continue;
            }

            int j = i + 1; // 往后的起点

            int end = i + len;

            while (j <= end) {

                int len2 = getLen(nums, j, end);

                if (len2 == 0) {
                    max = Math.max(max, j - i + 1);
                    break;
                }

                end = j + len2;

                j++;
            }
        }

        return max;


    }

    /**
     * 能返回start往后面多少个满足and运算是0
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private static int getLen(int[] nums, int start, int end) {
        int len = 0;
        for (int i = start + 1; i <= end; i++) {
            if ((nums[start] & nums[i]) != 0) {
                break;
            }
            len++;
        }
        return len;
    }

}
