package com.jiajia.daily;

import com.jiajia.kit.ArrayUtils;

/**
 * Created by Numen_fan on 2023/1/17 1814. 统计一个数组中好对子的数目
 * Desc:
 */
public class Solution20230117 {
    public static void main(String[] args) {
        Solution20230117 s = new Solution20230117();

        System.out.println(s.countNicePairs(ArrayUtils.string2IntArray("[13,10,35,24,76]")));
    }

    /**
     * 超时了，看看人家官解是怎么做的 https://leetcode.cn/problems/count-nice-pairs-in-an-array/solutions/2064186/tong-ji-yi-ge-shu-zu-zhong-hao-dui-zi-de-ywux/
     * @param nums
     * @return
     */
    public int countNicePairs(int[] nums) {
        int mod = (int) 1e9 + 7;
        int n = nums.length;
        int ans = 0;
        int[] revNums = new int[n];
        for (int i = 0; i < n; i++) {
            revNums[i] = recv(nums[i]); // 转移得到所有的转向数组
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + revNums[j] == nums[j] + revNums[i]) {
                    ans = (ans + 1) % mod;
                    System.out.println("(" + i + "," + j + ")");
                }
            }
        }

        return ans;
    }

    private int recv(int a) {
//        String str = new StringBuilder(String.valueOf(a)).reverse().toString();
//        return Integer.parseInt(str);
        int temp = 0;
        while (a > 0) {
            temp = temp * 10 + a % 10;
            a /= 10;
        }

        return temp;

    }
}
