package com.jiajia.jingsai;

import com.jiajia.kit.ArrayUtils;

import java.util.Arrays;

/**
 * Created by Numen_fan on 2022/7/17
 * Desc:
 */
public class Solution302 {

    public static void main(String[] args) {

        Solution302 solution302 = new Solution302();

        System.out.println(solution302.numberOfPairs(new int[]{1})[0]);

       ArrayUtils.print(solution302.smallestTrimmedNumbers(new String[]{"102","473","251","814"}, new int[][]{{1,1},{2,3},{4,2},{1,2}}));

        System.out.println(solution302.minOperations(new int[]{3,2,6,2,35,5,35,2,5,8,7,3,4}, new int[]{105,70,70,175,105,105,105}));


    }

    /**
     * 6120. 数组能形成多少数对
     * @param nums
     * @return
     */
    public int[] numberOfPairs(int[] nums) {

        int[] ans = new int[2];
        Arrays.sort(nums);
        int pair = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                pair++;
                i++;
            }
        }

        ans[0] = pair;
        ans[1] = nums.length - pair * 2;

        return ans;
    }

    /**
     * 6164. 数位和相等数对的最大和
     * @param nums
     * @return
     */
    public int maximumSum(int[] nums) {
        if (nums.length < 2) {
            return -1;
        }

        int index = -1;
        Arrays.sort(nums);
        int max = -1;

        for (int i = nums.length - 1; i > index; i--) {
            int sum1 = getSum(nums[i]);
            for (int j = i - 1; j > index; j--) {
                if (sum1 == getSum(nums[j])) {
                    // 找到了
                    max = Math.max(max, nums[i] + nums[j]);
                    index = j;
                }
            }
        }

        return max;
    }

    private int getSum(int num) {
        if (num > 0 && num < 10) {
            return num;
        }

        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    /**
     * 6121. 裁剪数字后查询第 K 小的数字
     * @param nums
     * @param queries
     * @return
     */
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String[] newNums = clip(nums, queries[i][1]);
            ans[i] = find(newNums, queries[i][0]);
        }
        return ans;

    }

    private String[] clip(String[] nums, int k) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = nums[i].substring(nums[i].length() - k);
        }
        return strs;
    }

    /**
     * 找到nums中第k小的数字的下标
     *
     * @param nums
     * @param k
     * @return
     */
    private int find(String[] nums, int k) {
        Point[] points = new Point[nums.length];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(nums[i], i);
        }

        Arrays.sort(points);

        return points[k - 1].index;
    }

    static class Point implements Comparable<Point> {
        public String num;
        public int index;
        public Point(String num, int index) {
            this.index = index;
            this.num = num;
        }


        @Override
        public int compareTo(Point o) {
            if (this == o) {
                return 0;
            }

            if (this.num.compareTo(o.num) == 0) {
                return this.index - o.index;
            } else {
                return this.num.compareTo(o.num);
            }
        }
    }

    /**
     * 6122. 使数组可以被整除的最少删除次数
     * @param nums
     * @param numsDivide
     * @return
     */
    public int minOperations(int[] nums, int[] numsDivide) {

        Arrays.sort(nums);

        int ans = 0;

        boolean find = false;

        for (int i = 0; i < nums.length; i++) {
            if (match(nums[i], numsDivide)) {
                find = true;
                break;
            } else {
                // 删除
                int num = nums[i];
                while (i < nums.length && nums[i] == num){
                    i++;
                    ans++;
                }
                i--;
            }
        }

        return find ? ans : -1;

    }

    private boolean match(int num, int[] numsDivide) {
        for (int s : numsDivide) {
            if (s % num != 0) {
                return false;
            }
        }
        return true;
    }

}
