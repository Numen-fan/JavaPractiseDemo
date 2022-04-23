package com.jiajia.hard;

/**
 * @lc app=leetcode.cn id=37 lang=java
 * [37] 解数独
 */

public class SolveSudoku37 {

    public static void main(String[] args) {
        int a = 3;
        char b = (char) (3 + '0');

        System.out.println(b);
    }

    public void solveSudoku(char[][] board) {
        backTracking(board);
    }

    /**
     * 双层递归
     */
    private boolean backTracking(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j] != '.') { // 直接走下一个
                    continue;
                }

                for (int k = 1; k <= 9; k++) {
                    if (valid(board, i, j, k)) {
                        board[i][j] =(char)(k + '0');
                        if (backTracking(board)) { // 不需要指定下一个位置
                            return true;
                        }
                        // 回溯
                        board[i][j] = '.'; // 开始取1-9中的下一个
                    }
                }
                return false; // 说明1-9不能满足这个位置了，即棋盘无解了。
            }
        }
        return true; // 遍历完了整个棋盘，则一定找到了解
    }

    /**
     * 校验board中[row][col]摆放k是否有效
     */
    private boolean valid(char[][] board, int row, int col, int k) {
        char ch = (char)(k + '0');
        // 同行不能有相同的数
        for (int i = 0; i < 9; i++) {
            if (ch== board[row][i]) {
                return false;
            }
        }

        // 同列不能有相同的数
        for (int i = 0; i < 9; i++) {
            if (ch == board[i][col]) {
                return false;
            }
        }

        // 3 x 3方格中不能有相同的
        // 计算row和col落在第几个3x3方格中的row和col起点
        int rowIndex = (row / 3) * 3;
        int colIndex = (col / 3) * 3;

        // 注意 < 条件啊
        for (int i = rowIndex ; i < rowIndex + 3; i++) {
            for(int j = colIndex; j < colIndex + 3; j++) {
                if (ch == board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
