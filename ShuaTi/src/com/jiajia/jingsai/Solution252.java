package com.jiajia.jingsai;

import java.util.Arrays;

public class Solution252 {

    public static void main(String[] args) {
        System.out.println(isThree(9));

        int[] a = {5,2,1};

        System.out.println(numberOfWeeks(a));
    }

    /**
     * 三除数
     * @param n
     * @return
     */
    public static boolean isThree(int n) {
        int tmp = n >> 1; // 右移一位
        int cnt = 0;
        while(tmp > 1) {
            if (n % tmp == 0) {
                cnt++;
            }
            tmp--;
        }
        return cnt == 1;
    }

    /**
     *  5831. 你可以工作的最大周数
      */
    public static long numberOfWeeks(int[] milestones) {
        Arrays.sort(milestones); // 从小到大排序
        int len = milestones.length;
        if (milestones.length == 1) {
            return 1;
        }
//        int result = milestones[0];
//        for (int i = 1; i < milestones.length - 1; i++) {
//            result += milestones[i];
//        }
//        if (milestones[len - 1] > milestones[len - 2] + 1) {
//            result += milestones[len - 1] - 1;
//        } else {
//            result += milestones[len - 1];
//        }
//        return  result;

//        int result = 0;
//        int cnt = 0; // 总共循环了多少轮
//        for (int i = 0; i < len; i++) {
//            if (milestones[i] - cnt <= 0) {
//                continue;
//            }
//            int tmpCnt = milestones[i] - cnt; // 当前会执行多少轮
//            if (i < len - 1) {
//                cnt += tmpCnt;
//                result += tmpCnt * (len - i);
//            } else {
//                if (tmpCnt > 0) {
//                    result++;
//                }
//            }
//        }
//        return result;

        Arrays.sort(milestones);
        long total = 0;
        for(int x : milestones){
            total += x;
        }
        int n = milestones.length;
        long max = milestones[n - 1];
        if(max + max - 1 <= total){
            return total;
        }
        return (total - max) * 2 + 1;
    }
}
