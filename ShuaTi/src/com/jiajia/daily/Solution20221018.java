package com.jiajia.daily;

import com.jiajia.kit.ArrayUtils;

/**
 * Created by Numen_fan on 2022/10/18
 * Desc:[904] 水果成篮
 */
public class Solution20221018 {

    public static void main(String[] args) {
        System.out.println(totalFruit(ArrayUtils.string2IntArray("[0,1,0,2,2]")));
    }


    public static int totalFruit(int[] fruits) {

        if (fruits.length < 2) {
            return fruits.length;
        }

        int ans = 0;

        int index = 0;
        int start = 0;
        int first = fruits[0];
        while(index < fruits.length && fruits[index] == first) {
            index++;
        }

        if (index >= fruits.length) {
            return fruits.length;
        }

        int second = fruits[index];

        while(index < fruits.length) {
            if (fruits[index] == second || fruits[index] == first) {
                index++;
                continue;
            }

            if (first == -1 || second == -1) {
                if (first == -1) {
                    first = fruits[index];
                } else {
                    second = fruits[index];
                }
                index++;
                continue;
            }

            // 出现别的种类了
            // 先把这个窗口的长度保存
            ans = Math.max(ans, index - start);

            // 向前找到不同的数
            int j = index - 1;
            int num = fruits[j];

            while(j >= 0 && fruits[j] == num) {
                j--;
            }
            start = j + 1;

            if (num == first) {
                second = -1;
            } else {
                first = -1;
            }

        }

        ans = Math.max(ans, index - start);

        return ans;

    }
}
