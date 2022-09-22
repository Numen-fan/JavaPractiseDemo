package com.jiajia.daily;

import com.jiajia.kit.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 1640
 */
public class Solution20220922 {

    public static void main(String[] args) {
        int[] a = ArrayUtils.string2IntArray("[91,4,64,78]");
        int[][] b = ArrayUtils.string2IntArray2("[[78],[4,64],[91]]");

        System.out.println(canFormArray(a, b));
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] t : pieces) {
            map.put(t[0], Arrays.stream(t).boxed().collect(Collectors.toList()));
        }

        for (int i = 0; i < arr.length;) {
            int a = arr[i];
            List<Integer> list = map.get(a);
            if(list == null) {
                return false;
            }
            for (int j = 0; j < list.size(); ) {
                if (arr[i] == list.get(j)) {
                    i++; // 这里控制i的自增
                    j++;
                } else {
                    return false;
                }
            }
        }
        return true;

    }
}
