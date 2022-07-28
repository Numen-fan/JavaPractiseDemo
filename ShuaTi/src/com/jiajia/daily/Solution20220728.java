package com.jiajia.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331. 数组序号转换
 */
public class Solution20220728 {

    public static void main(String[] args) {
        Solution20220728 solution20220728 = new Solution20220728();

        solution20220728.arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12});
    }



    public int[] arrayRankTransform(int[] arr) {

        int[] ans = new int[arr.length];

        int[] temp = Arrays.copyOf(arr, arr.length);

        Arrays.sort(arr);

        Map<Integer, Integer> ranks = new HashMap<>();

        for (int j : arr) {
            if (!ranks.containsKey(j)) {
                ranks.put(j, ranks.size() + 1);
            }
        }

        for (int i = 0; i < temp.length; i++) {
            ans[i] = ranks.get(temp[i]);
        }

        return ans;
    }

}
