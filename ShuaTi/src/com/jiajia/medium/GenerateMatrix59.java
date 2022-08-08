package com.jiajia.medium;

import com.jiajia.kit.ArrayUtils;

/**
 * [59] 螺旋矩阵 II
 */
public class GenerateMatrix59 {

    public static void main(String[] args) {
        ArrayUtils.print(generateMatrix(3));
    }


    public static int[][] generateMatrix(int n) {

        int[][] ans = new int[n][n];

        int i = 1;

        int x = 0, y = 0;

        while(i <= n * n) {

            // 先向右边走
            while(i <= n * n && y < n && ans[x][y] == 0) {
                ans[x][y++] = i++;
            }

            // 往下边走
            x++;
            y--;
            while(i <= n * n && x < n && ans[x][y] == 0) {
                ans[x++][y] = i++;
            }
            x--;
            y--;

            // 往左边走
            while(i <= n * n && y >= 0 && ans[x][y] == 0) {
                ans[x][y--] = i++;
            }
            y++;
            x--;

            // 往上走
            while(i <= n * n && x >= 0 && ans[x][y] == 0) {
                ans[x--][y] = i++;
            }
            x++;
            y++;

        }

        return ans;

    }

}
