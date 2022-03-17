package com.jiajia.medium;

import com.jiajia.kit.ArrayUtils;

import java.util.Arrays;

public class EraseOverlapIntervals435 {

    public static void main(String[] args) {
        int[][] arr = ArrayUtils.string2IntArray2("[[-52,31], [-73,-26], [82,97], [-65,-11], [-62,-49], [95,99], [58,95], [-31,49], [66,98], [-63,2], [30,47], [-40,-26]]");
        System.out.println(method1(arr));
    }

    /**
     * 思想： 
     * 先对二维数组进行排序，按照start从小到大，
     * 如果start相同，再按照end从小到大排序。
     * 从前往后取区间，记录当前不重叠的end，
     * 如果当前区间的start < end, 则将当前区间移出。
     * 同时要注意某一个区间很大的情况，比如[1,9][2,3][4,5][6,7],应该去掉[1,9]
     * 【注意排序时如果使用减法，注意整数溢出问题】
     */
    private static int method1(int[][] intervals) {
        int ans = 0;
        if(intervals.length < 2) {
            return 0;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int end = intervals[0][1]; // 当前覆盖的end
        for(int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int tempEnd = intervals[i][1];
            if(start < end) {
                ans++;
                end = Math.min(end, tempEnd);
            } else {
                end = tempEnd;
            }
        }
        return ans;
    }

}
