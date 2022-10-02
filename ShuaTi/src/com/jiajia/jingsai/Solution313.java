package com.jiajia.jingsai;

import com.jiajia.kit.ArrayUtils;

import java.util.Arrays;

/**
 * Created by Numen_fan on 2022/10/2
 * Desc: 313周赛
 */
public class Solution313 {

    public static void main(String[] args) {
        System.out.println(commonFactors(25, 30));

        System.out.println(maxSum(ArrayUtils.string2IntArray2("[[6,2,1,3],[4,2,1,5],[9,2,8,7],[4,1,2,9]]")));

        System.out.println(minimizeXor(1, 12));
    }

    /**
     * 6192. 公因子的数目
     * @param a
     * @param b
     * @return
     */
    public static int commonFactors(int a, int b) {
        int c = Math.min(a, b);
        int ans = 1; // 1一定是

        for (int i = 2; i <= c; i++) {
            if (a % i == 0 && b % i == 0) {
                ans++;
            }
        }

        return ans;

    }


    /**
     * 6193. 沙漏的最大总和
     * @param grid
     * @return
     */
    public static int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;

        // 以沙漏的中心点开始遍历
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int temp = 0;
                temp += grid[i - 1][j - 1];
                temp += grid[i - 1][j];
                temp += grid[i - 1][j + 1];
                temp += grid[i][j];
                temp += grid[i + 1][j - 1];
                temp += grid[i + 1][j];
                temp += grid[i + 1][j + 1];
                ans = Math.max(ans, temp);
            }
        }

        return ans;
    }

    /**
     * 6194. 最小 XOR
     * @param num1
     * @param num2
     * @return
     */
    public static int minimizeXor(int num1, int num2) {
        String num2Binary = Integer.toBinaryString(num2);
        int cntNum2 = num2Binary.replace("0", "").length(); // 1的数目

        String num1Binary = Integer.toBinaryString(num1);
        int cntNum1 = num1Binary.replace("0", "").length();

        // 1的数量相同
        if (cntNum1 == cntNum2) {
            return num1;
        }

        if (cntNum1 > cntNum2) { // 说明填充cnt2个1，从高位
            char[] chs = new char[num1Binary.length()];
            Arrays.fill(chs, '0');
            int index = 1;
            for (int i = 0; i < num1Binary.length(); i++) {
                if (index > cntNum2) {
                    break;
                }
                if (num1Binary.charAt(i) == '1') {
                    chs[i] = '1';
                    index++;
                }
            }
            return Integer.parseInt(new String(chs), 2);
        }

        int cnt = cntNum2 - cntNum1; // 还要填充cnt个1到最后
        char[] chs = new char[num1Binary.length()];
        Arrays.fill(chs, '0');
        for (int i = 0; i < num1Binary.length(); i++) {
            if (num1Binary.charAt(i) == '1') {
                chs[i] = '1';
            }
        }

        // 从后向前找cnt个0填充为1
        int index = chs.length - 1;
        while (cnt > 0) {
            while (index >= 0 && chs[index] == '1') {
                index--;
            }
            if (index >= 0) {
                chs[index] = '1';
                cnt--;
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (cnt > 0) {
            for (int j = 0; j < cnt; j++) {
                sb.append('1');
            }
        }

        return Integer.parseInt(new String(chs) + sb, 2);
    }
}
