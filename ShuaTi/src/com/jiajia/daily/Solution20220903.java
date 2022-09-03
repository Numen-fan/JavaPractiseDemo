package com.jiajia.daily;

import com.jiajia.kit.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Numen_fan on 2022/9/3
 * Desc: [646] 最长数对链
 */
public class Solution20220903 {

    public static void main(String[] args) {

        int[][] arr = ArrayUtils.string2IntArray2("[[1,2], [2,3], [3,4]]");

        System.out.println(Solution20220903.findLongestChain(arr));


    }
    public static int findLongestChain(int[][] pairs) {

        // 按照结尾的数字排序，越快结尾，排在越前面
        Arrays.sort(pairs, (Comparator.comparingInt(o -> o[1])));

        int ans = 0;
        int last = Integer.MIN_VALUE;
        for (int[] a : pairs) {
            if (a[0] > last) {
                last = a[1];
                ans++;
            }
        }
        return ans;
    }

}
