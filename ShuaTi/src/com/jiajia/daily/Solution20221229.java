package com.jiajia.daily;

import java.util.ArrayList;
import java.util.List;

public class Solution20221229 {

    public static void main(String[] args) {

    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] cnt1 = new int[101];
        int[] cnt2 = new int[101];
        int[] cnt3 = new int[101];
        for (int i = 0; i < nums1.length; i++) {
            cnt1[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            cnt2[nums2[i]]++;
        }
        for (int i = 0; i < nums3.length; i++) {
            cnt3[nums3[i]]++;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 101; i++) {
            if (cnt1[i] == 0 && (cnt2[i] == 0 || cnt3[i] == 0)) {
                continue;
            }
            if (cnt2[i] == 0 && (cnt1[i] == 0 || cnt3[i] == 0)) {
                continue;
            }
            if (cnt3[i] == 0 && (cnt1[i] == 0 || cnt2[i] == 0)) {
                continue;
            }
            list.add(i);
        }

        return list;
    }

}
