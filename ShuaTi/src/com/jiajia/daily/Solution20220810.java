package com.jiajia.daily;

/**
 * 640. 求解方程
 */
public class Solution20220810 {

    public static void main(String[] args) {
        Solution20220810 solution20220810 = new Solution20220810();
        System.out.println(solution20220810.solveEquation("0x=0"));
    }

    public String solveEquation(String equation) {
        // 表达式：xCnt * X = digit => X = digit / xCnt;
        int[] res = processEquation(equation);

        if (res[0] == res[1] && res[0] == 0) {
            return "Infinite solutions";
        } else if (res[0] == 0) {
            return "No solution";
        } else {
            return "x=" + res[1] / res[0];
        }
    }

    /**
     * 处理＝前后的表达式，进行表达式化简
     * @param equation
     * @return
     */
    private int[] processEquation(String equation) {
        int xCnt = 0; // 最后左侧多少个x
        int digit = 0; // 最后右侧数字部分

        boolean left = true; // 标识当前处理是左侧部分，false表示右侧部分

        char[] chs = equation.toCharArray();

        int i = 0;
        while (i < chs.length) {
            // 每次while处理，从一个符号位或者表达式第一个位置开始
            if (chs[i] == '=') {
                i++;
                left = false;
                continue;
            }

            int sign = 1; // 正数
            if (chs[i] == '-') {
                sign = -1; // 负数
                i++; // 跳过符号位
            } else if (chs[i] == '+') {
                i++; // 跳过符号位
            }

            // 处理符号后面的部分
            int num = 0;
            boolean isXPart = false;
            boolean hasDigit = false;
            while (i < chs.length && (Character.isDigit(chs[i]) || chs[i] == 'x')) {
                if (chs[i] == 'x') {
                    isXPart = true;
                } else {
                    num = num * 10 + (chs[i] - '0');
                    hasDigit = true;
                }
                i++;
            }

            // 这部分处理完毕
            if (isXPart) { // 是未知数x
                int cnt = hasDigit ? num : 1;
                cnt *= sign;
                if (left) {
                    xCnt += cnt;
                } else {
                    xCnt -= cnt;
                }
            } else { // 是数字部分
                num *= sign;
                if (left) {
                    digit -= num;
                } else {
                    digit += num;
                }
            }
        }

        return new int[]{xCnt, digit};
    }

}
