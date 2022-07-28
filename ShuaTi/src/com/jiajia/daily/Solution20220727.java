package com.jiajia.daily;

/**
 * Created by Numen_fan on 2022/7/27
 * Desc:
 */
public class Solution20220727 {

    public static void main(String[] args) {
        Solution20220727 solution20220727 = new Solution20220727();

        System.out.println(solution20220727.fractionAddition("1/3-1/2"));
    }

    /**
     * 参考了官方的解法
     * 对于两个分数 a/b + c / d = a * d + c * b / b * d, 关键
     * @param expression
     * @return
     */
    public String fractionAddition(String expression) {

        int upNum = 0;
        int downNum = 1; // 默认开始 0 / 1;

        int index = 0;
        int n = expression.length();

        while(index < n) {
            int tempUp = 0;
            int tempDown = 0;
            // 记录符号位
            int sign = 1;
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+')  {
                sign = expression.charAt(index) == '-' ? -1 : 1;
                index++;
            }

            // 寻找分子
            while (index < n && Character.isDigit(expression.charAt(index))) {
                tempUp = tempUp * 10 + expression.charAt(index) - '0';
                index++;
            }

            tempUp = tempUp * sign; // 加上符号位

            // 遇到了 '/'
            index++;

            while (index < n && Character.isDigit(expression.charAt(index))) {
                tempDown = tempDown * 10 + expression.charAt(index) - '0';
                index++;
            }

            upNum = upNum * tempDown + tempUp * downNum;

            downNum = downNum * tempDown;

        }

        if (upNum == 0) {
            return "0/1";
        }

        int gcd = gcd(downNum, Math.abs(upNum));

        return Long.toString(upNum / gcd).trim() + "/" + Long.toString(downNum / gcd).trim();

    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

}
