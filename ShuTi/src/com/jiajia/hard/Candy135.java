package com.jiajia.hard;

import java.util.Arrays;

public class Candy135 {

    public static void main(String[] args) {
        System.out.println(method2(new int[]{1, 0, 2}));
    }

    /**
     * 先从左到右，确定右边比左边大的孩子的糖果
     * 再从右到左，确定左边比右边大的孩子的糖果
     */
    private static int method2(int[] ratings) {
        int[] candyVec = new int[ratings.length];
        Arrays.fill(candyVec, 1);

        // 先从左到右
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyVec[i] = candyVec[i - 1] + 1;
            }
        }
        // 再从右到左
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyVec[i] = Math.max(candyVec[i + 1] + 1, candyVec[i]);
            }
        }

        int ans = 0;
        for (int candy : candyVec) {
            ans += candy;
        }
        return ans;
    }

}
