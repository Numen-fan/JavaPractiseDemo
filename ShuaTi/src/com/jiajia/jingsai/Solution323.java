package com.jiajia.jingsai;

import com.jiajia.kit.ArrayUtils;

import java.util.*;

/**
 * Created by Numen_fan on 2022/12/11
 * Desc:
 */
public class Solution323 {

    public static void main(String[] args) {
        System.out.println(deleteGreatestValue(ArrayUtils.string2IntArray2("[[1,2,4],[3,3,1]]")));

        Solution323 s = new Solution323();

        System.out.println(s.longestSquareStreak(ArrayUtils.string2IntArray("[4,3,6,16,8,2]")));

        System.out.println(Math.ceil(5d / 3));

    }

    /**
     * 6257. 删除每行中的最大值
     * @param grid
     * @return
     */
    public static int deleteGreatestValue(int[][] grid) {
        int ans  = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int k = 0; k < col; k++) { // 删除col列数据
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < row; i++) {
                int maxValue = grid[i][0];
                int maxIndex = 0;
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] > maxValue) {
                        maxIndex = j;
                        maxValue = grid[i][j];
                    }
                }
                grid[i][maxIndex] = -1; // 这一行的最大值标记删除
                max = Math.max(maxValue, max); // 每一行的最大值
            }
            ans += max;
        }

        return ans;
    }


    Queue<Integer> path = new PriorityQueue<>();
    int ans = -1;

    /**
     * 6258. 数组中最长的方波
     * @param nums
     * @return
     */
    public int longestSquareStreak(int[] nums) {
        // 回溯法，超时了
//        backTracking(0, nums);
//        return ans;


        Arrays.sort(nums);
        int n=nums.length,max=nums[n-1],len=-1;
        int[] dp=new int[max+1];
        for(int i=0;i<n;i++){
            dp[nums[i]]=1;
        }
        for(int i=0;i<n;i++){
            int x=(int)Math.sqrt(nums[i]);
            if(x*x!=nums[i])continue;
            dp[nums[i]]=dp[x]+1;
        }
        for(int i=0;i<=max;i++){
            if(dp[i]>=2)len=Math.max(len,dp[i]);
        }
        return len;

    }

    private boolean match(Queue<Integer> list) {
        int last = list.poll();
        while (list.size() > 0) {
            int cur = list.poll();
            if (last * last != cur) {
                return false;
            }
            last = cur;
        }
        return true;
    }


    private void backTracking(int startIndex, int[] nums) {
        if (path.size() > 1) {
            if (match(path)) {
                ans = Math.max(ans, path.size());
            } else {
                return;
            }
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]); // 添加本层节点
            backTracking(i + 1, nums);
            path.remove(path.size() - 1); // 回溯
        }
    }
}
