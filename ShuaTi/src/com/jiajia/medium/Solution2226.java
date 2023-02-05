package com.jiajia.medium;

import com.jiajia.kit.ArrayUtils;

import java.util.Arrays;

/**
 * Created by Numen_fan on 2023/2/5
 * Desc: 2226. 每个小孩最多能分到多少糖果
 */
public class Solution2226 {

    public static void main(String[] args) {
        System.out.println(Arrays.stream(ArrayUtils.string2IntArray("[5,8,6]")).max().getAsInt());
        Solution2226 s = new Solution2226();
        System.out.println(s.maximumCandies(ArrayUtils.string2IntArray("[5,8,6]"), 3));
    }

    public int maximumCandies(int[] candies, long k) {
        int min = 1;
        int max = Arrays.stream(candies).max().getAsInt() + 1;

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (check(candies, mid, k)) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min - 1;
    }


    private boolean check(int[] candies, int num, long k) {
        long cnt = 0;
        for (int i = 0; i < candies.length; i++) {
            cnt += candies[i] / num;
        }
        return cnt >= k;
    }

}
