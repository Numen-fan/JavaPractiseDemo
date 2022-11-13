package com.jiajia.daily;

import com.jiajia.kit.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Numen_fan on 2022/11/9
 * Desc: 764. 最大加号标志
 */
public class Solution20221109 {

    public static void main(String[] args) {

        System.out.println(orderOfLargestPlusSign(20, ArrayUtils.string2IntArray2("[[0,7],[0,8],[0,13],[0,15],[0,17],[1,0],[1,1],[1,7],[1,10],[1,16],[1,18],[2,6],[2,10],[2,13],[2,15],[3,0],[3,9],[3,10],[3,11],[3,12],[3,14],[3,15],[3,18],[4,0],[4,6],[4,7],[4,12],[5,6],[5,7],[5,8],[5,15],[5,17],[6,3],[6,8],[6,10],[6,14],[6,18],[7,2],[7,12],[7,13],[7,16],[7,19],[8,1],[9,0],[9,3],[9,15],[9,18],[10,2],[10,10],[10,13],[10,14],[11,1],[11,8],[11,9],[11,10],[11,13],[11,14],[11,17],[12,11],[12,14],[12,15],[12,18],[12,19],[13,3],[13,4],[13,18],[14,0],[14,1],[14,3],[14,4],[14,5],[14,9],[14,18],[15,7],[15,9],[15,13],[15,18],[15,19],[17,2],[17,7],[17,9],[17,10],[17,12],[17,15],[17,16],[17,19],[18,2],[18,3],[18,5],[18,6],[18,8],[18,11],[18,18],[19,0],[19,5],[19,7],[19,13],[19,19]]")));
    }

    public static int orderOfLargestPlusSign(int n, int[][] mines) {

        List<String> set = new ArrayList<>();

        for (int i = 0; i < mines.length; i++) {
            set.add(mines[i][0] + String.valueOf(mines[i][1]));
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 从这个中心点开始
                if (set.contains(getString(i, j))) {
                    continue;
                }

                int step = 1;

                while(true) {

                    // 向左边走
                    if((j - step) < 0 || set.contains(getString(i, j - step))) {
                        break;
                    }

                    // 向上走
                    if ((i - step) < 0 || (set.contains(getString(i - step, j)))) {
                        break;
                    }

                    // 向右边走
                    if ((j + step) >= n || set.contains(getString(i, j + step))) {
                        break;
                    }

                    // 向下走
                    if((i + step) >= n || set.contains(getString(i + step, j))) {
                        break;
                    }

                    // 当前满足
                    step++;
                }

                ans = Math.max(ans, step);

            }
        }

        return ans;

    }

    private static String getString(int a, int b) {
        return a + String.valueOf(b);
    }
}
