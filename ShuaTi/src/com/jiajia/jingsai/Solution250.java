package com.jiajia.jingsai;

public class Solution250 {

    public static void main(String[] args) {
        String text = "hello world";
        String brokenLetters = "ad";
        System.out.println(canBeTypedWords(text, brokenLetters));

        int[] rungs = {4,8,12,16};
        System.out.println(addRungs2(rungs, 3));

//        int[][] points = {{1,2,3},{1,5,1},{3,1,1}};
//        int[][] points = {{0,4,3,0,0}};
        int[][] points = {{0,3,0,4,2},{5,4,2,4,1},{5,0,0,5,1},{2,0,1,0,3}};
        System.out.println(maxPoints(points));
    }


    public static int canBeTypedWords(String text, String brokenLetters) {
        int result = 0;
        String[] textArr = text.split(" ");
        for (String s : textArr) {
            for (int j = 0; j < brokenLetters.length(); j++) {
                if (s.contains(String.valueOf(brokenLetters.charAt(j)))) {
                    result++;
                    break;
                }
            }
        }
        return textArr.length - result;
    }

    public static int addRungs(int[] rungs, int dist) {
        int result = 0;
        int pos = 0;
        for (int rung : rungs) {
            if (pos + dist >= rung) {
                pos = rung; // 达到新的台阶位置
                continue;
            }
            while (pos + dist < rung) { // 无法到达下一台阶，需要添加台阶
                pos += dist; // 更新添加台阶后的位置
                result++; // 累加结果
            }
            pos = rung;
        }
        return result;
    }

    public static int addRungs2(int[] rungs, int dist) {
        int result = 0;
        int pos = 0;
        for (int i = 0; i < rungs.length; ) {
            if (rungs[i] - pos > dist) {
                pos += dist;
                result++;
                continue;
            }
            pos = rungs[i];
            i++;
        }
        return result;
    }

    public static long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        int result = 0;
        int[] cols = new int[m];
        for (int i = 0; i < m; i++) {
            int maxColIndex = 0;
            int maxColNum = points[i][0];
            for (int j = 0; j < n; j++) {
                if (points[i][j] > maxColNum) {
                    maxColIndex = j;
                    maxColNum = points[i][j];
                }
            }
            result += points[i][maxColIndex];
            cols[i] = maxColIndex;
        }
        if (m < 2) {
            return result;
        }
        for (int i = 1; i < m; i++) {
            result -= Math.abs(cols[i] - cols[i -1]);
        }
        return result;
    }

}
