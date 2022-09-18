package com.jiajia.kit;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数组工具类
 */
public class ArrayUtils {

    /**
     * 一维整形数组打印
     */
    public static void print(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println(); // 换行
    }

    public static void print(double[] array) {
        for (double j : array) {
            System.out.print(j + " ");
        }
        System.out.println(); // 换行
    }

    /**
     * 二维数组打印
     */
    public static void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println(); // 打完一行换行
        }
    }

    /**
     * @param str "[1,2,3,4]"
     * @return int[] {1,2,3,4}
     */
    public static int[] string2IntArray(String str) {
        if (str == null || str.trim().length() == 0) {
            return new int[]{};
        }
        String tempStr = str.trim();
        tempStr = tempStr.replace("[", "").replace("]", "");

        String[] strArr = tempStr.split(",");
        int[] result = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            result[i] = Integer.parseInt(strArr[i]);
        }
        return result;
    }

    /**
     * @param str "[[1,2], [2,3]]"
     * @return int[][] {{1,2}, {2,3}}
     */
    public static int[][] string2IntArray2(String str) {
        if (str == null || str.trim().length() == 0) {
            return new int[][]{};
        }

        List<int[]> list = new ArrayList<>();

        String tempStr = str.trim();
        tempStr = tempStr.substring(1, tempStr.length() - 1); // 不包括length - 1位置字符 => [1,2],[2,3],[3,4]

        String reg = "\\[[0-9]+[,]*[0-9]*\\]";

        Matcher matcher = Pattern.compile(reg).matcher(tempStr);

        while (matcher.find()) {
            list.add(string2IntArray(matcher.group()));
        }

        return list.toArray(new int[][]{});

    }



}
