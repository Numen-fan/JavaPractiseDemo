package com.jiajia.daily;

import com.jiajia.kit.ArrayUtils;
import kotlin.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Numen_fan on 2022/10/1
 * Desc:
 */
public class Solution20220930 {

    public static void main(String[] args) {

        setZeroes(ArrayUtils.string2IntArray2("[[1,1,1],[1,0,1],[1,1,1]]"));
    }


    public static void setZeroes(int[][] matrix) {
        int m = matrix.length; // 行数
        int n = matrix[0].length; // 列数

        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    pairs.add(new Pair(i, j));
                }
            }
        }

        for (Pair pair : pairs) {
            clearRows(matrix, pair.getFirst());
            clearCols(matrix, pair.getSecond());
        }
    }

    private static void clearRows(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private static void clearCols(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getFirst() {
            return x;
        }

        public int getSecond() {
            return y;
        }
    }





}
