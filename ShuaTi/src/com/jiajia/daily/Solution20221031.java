package com.jiajia.daily;

/**
 * Created by Numen_fan on 2022/10/31
 * Desc: 481. 神奇字符串
 */
public class Solution20221031 {

    public static void main(String[] args) {
        System.out.println(Solution20221031.magicalString(20));
    }

    public static int magicalString(int n) {

        if (n < 4) {
            return 1;
        }

        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 2;

        int i = 3; // 从第三个开始填充，
        int j = 2; // 填充几次

        while (i < n) {
            // 找到填充的值
            int fill = arr[i - 1] == 1 ? 2 : 1;
            if (arr[j] == 1) {
                arr[i++] = fill;
            } else {
                arr[i++] = fill;
                if (i < n) {
                    arr[i++] = fill;
                }
            }
            j++; // 下一个填充的数需要填充几次
        }

        int cnt = 0;
        for (int a : arr) {
            if (a == 1) {
                cnt++;
            }
        }

        return cnt;
    }
}
