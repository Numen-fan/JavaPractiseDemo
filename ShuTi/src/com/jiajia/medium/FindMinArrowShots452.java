package com.jiajia.medium;

import java.util.Arrays;

public class FindMinArrowShots452 {

    public static void main(String[] args) {

        int[][] points = new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};

        System.out.println(method1(points));

    }

    /**
     * 先将二维数组进行排序，按照Xstart从小到大排序，对于Xstart相等的，按照Xend从小到大排序
     * 从小到大排序，获取当前气球的区间start-end,向后面遍历，所有start落在这个区间的，则认为可以一支箭搞定。
     * 重点是记录当前的end。
     */
    private static int method1(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {
                    return 0;
                } else {
                    return o1[1] < o2[1] ? -1 : 1;
                }
            } else {
                return o1[0] < o2[0] ? -1 : 1;
            }
        });

        int ans = 0;
        int tempEnd = points[0][1];
        ans++; // 默认第一个
        for(int i = 1; i < points.length; i++) {
            int start = points[i][0];
            int end = points[i][1];
            if(start <= tempEnd) {
                tempEnd = Math.min(end, tempEnd); // 需要更新最大区间，避免 [1,10] [3,8] [9,10]问题
                continue;
            }
            tempEnd = end; // 下一支箭的最大覆盖范围了
            ans++;
        }
        return ans;
    }

}
