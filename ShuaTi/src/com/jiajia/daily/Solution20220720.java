package com.jiajia.daily;

import java.util.ArrayList;
import java.util.List;

public class Solution20220720 {

    public static void main(String[] args) {
        Solution20220720 solution20220720 = new Solution20220720();

        solution20220720.shiftGrid(new int[][]{{1},{2},{3},{4},{7},{6},{5}}, 23);
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length; // 行
        int n = grid[0].length; // 列

        List<List<Integer>> ans = new ArrayList<>(m); // 每个list就是一行

        int[][] res = new int[m][n];

        for(int i = 0; i < m; i++) {
            ans.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int local = i * n + j + k; // 移动后的位置

                int row = (local / n) % m;
                int col = local % n;

                res[row][col] = grid[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans.get(i).add(res[i][j]);
            }
        }

        return ans;
    }

}
