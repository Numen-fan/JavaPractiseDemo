package com.jiajia.daily;

import com.jiajia.kit.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Numen_fan on 2022/9/24
 * Desc:
 */
public class Solution20220924 {

    public static void main(String[] args) {
        int[] arr = {5,7,1,4};
        ArrayUtils.print(decrypt(arr, 3));
    }


    public static int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        if (k == 0) {
            Arrays.fill(ans, 0);
            return ans;
        }

        // 1 利用stream + list进行反转
//        List<Integer> list = Arrays.stream(code).boxed().collect(Collectors.toList());
//        if (k < 0) {
//            Collections.reverse(list);
//        }

        // 2 利用数组反转
        if (k < 0) {
            for (int i = 0; i < code.length / 2; i++) {
                code[i] ^= code[code.length - 1 - i];
                code[code.length - 1 - i] ^= code[i];
                code[i] ^= code[code.length - 1 - i];
            }
        }

        for (int i = 0; i < code.length; i++) {
            int t = 0;
            for (int j = 1; j <= Math.abs(k); j++) {
                int index = (j + i) % code.length;
                t += code[index];
            }
            ans[k < 0 ? code.length - i - 1 : i] = t;
        }
        return ans;
    }
}
