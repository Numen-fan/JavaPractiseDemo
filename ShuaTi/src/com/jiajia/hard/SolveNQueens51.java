package com.jiajia.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Numen_fan on 2022/4/18
 * Desc: N皇后问题
 */
public class SolveNQueens51 {

    private int[][] answer; // 记录一次解
    private boolean[] colUsed; // 记录哪些列被占用
    private final List<List<String>> result = new ArrayList<>(); // 保存所有的answer

    public static void main(String[] args) {
        SolveNQueens51 solveNQueens51 = new SolveNQueens51();
        solveNQueens51.solveNQueens(4);
        System.out.println(solveNQueens51.result);
    }

    public List<List<String>> solveNQueens(int n) {
        answer = new int[n][n];
        colUsed = new boolean[n];

        backTracking(n, 0);

        return result;
    }

    /**
     * @param n the num of Queeens
     * @param start place the start`s Queen
     */
    private void backTracking(int n, int start) {

        // 找到结果，start == n，即摆放完了n个皇后
        if(start == n) {
            // 将answer转为一个List<String>放入result中
            result.add(transAnsToResult());
            return;
        }

        // 这一层是为了摆放第start个
        for (int j = 0; j < n; j++) {
            if (!checkPlaceValid(n, start, j)) {
                continue;
            }

            // [i, j] 满足摆放一个皇后
            answer[start][j] = 1;
            colUsed[j] = true;

            // 开始下一个摆放
            backTracking(n, start + 1);

            // 回溯
            colUsed[j] = false;

            answer[start][j] = 0;

        }
    }

    /**
     * 判断当前这个位置是否可以摆放皇后
     * 同列和斜对角线上不能有皇后
     * @param row row行
     * @param col col列
     */
    public boolean checkPlaceValid(int n, int row, int col) {

        // 先check col这一列是否有皇后
        if (colUsed[col]) {
            return false;
        }

        // 查看[row, col]的对角线上是否有皇后
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(answer[i][j] == 1) {
                return false;
            }
        }

        for(int i = row, j = col; i < n && j < n; i++, j++) {
            if (answer[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (answer[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (answer[i][j] == 1) {
                return  false;
            }
        }

        return true;
    }

    private List<String> transAnsToResult() {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < answer.length; i++) {
            int[] row = answer[i];
            StringBuilder rowSb = new StringBuilder();
            for (int j = 0; j < row.length; j++) {
                if(row[j] == 1) {
                    rowSb.append("Q");
                } else {
                    rowSb.append(".");
                }
            }

            list.add(rowSb.toString());
        }
        return list;
    }

}
