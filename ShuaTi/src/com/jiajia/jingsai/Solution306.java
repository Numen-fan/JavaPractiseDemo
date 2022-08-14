package com.jiajia.jingsai;

import com.sun.tools.javac.Main;

import java.util.Stack;

/**
 * Created by Numen_fan on 2022/8/14
 * Desc:
 */
public class Solution306 {

    public static void main(String[] args) {

        Solution306 solution306 = new Solution306();

        System.out.println(solution306.edgeScore(new int[]{1, 0}));

        System.out.println(solution306.smallestNumber("DDD"));

    }

    /**
     * 6148. 矩阵中的局部最大值
     * @param grid
     * @return
     */
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int m = n - 2;

        int[][] ans = new int[m][m];

        for (int i = 0; i < m; i++) { // 控制行
            for (int j = 0; j < m; j++) { // 控制列

                // 遍历原始二维数组
                int maxValue = Integer.MIN_VALUE;

                for (int k = i; k < i + 3; k++) {
                    for (int p = j; p < j + 3; p++) {
                        maxValue = Math.max(maxValue, grid[k][p]);
                    }
                }

                ans[i][j] = maxValue;
            }
        }

        return ans;
    }

    /**
     * 6149. 边积分最高的节点
     * @param edges
     * @return
     */
    public int edgeScore(int[] edges) {

        int n = edges.length;

        long[] arr = new long[n]; // arr[i] 表示指向i节点的边积分

        for (int i = 0; i < n; i++) {
            arr[edges[i]] += i;
        }


        long ans = Long.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (ans < arr[i]) {
                ans = arr[i];
                index = i;
            }
        }

        return index;

    }


    /**
     * 6150. 根据模式串构造最小数字
     * @param pattern
     * @return
     */
    public String smallestNumber(String pattern) {
        pattern += 'I'; // 后面补齐一个I
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'D') { // 遇到D，就将升序的字符压桟
                stack.push(num++);
            } else {
                sb.append(num++);
                // 说明前面有D，说明前面的要大于后面的字符，按序先拼接当前的字符，并把之前的所有小号拼上
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }

        return sb.toString();




    }
}

