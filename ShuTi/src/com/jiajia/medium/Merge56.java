package com.jiajia.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Numen_fan on 2022/3/12
 * Desc:
 */
public class Merge56 {
    public static void main(String[] args) {

    }

    /**
     * 先对二维数组进行排序，按照start从小到大，start相等的按照end从小到大。
     * 从前向后遍历，确定某一段的start和end
     * 如果下一段的start < end, 则更新\当前end，否着当前的start和end为新的一段
     */
    private static int[][] method1(int[][] intervals) {
        List<int[]> ansList = new ArrayList<>();
        if (intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int tempStart = intervals[i][0];
            int tempEnd = intervals[i][1];
            if (tempStart > end) { // 前面的start和end为独立的一段
                ansList.add(new int[]{start, end});
                // 更新下一段的起点和终点
                start = tempStart;
                end = tempEnd;
            } else {
                // i 这一段和之前的一段重叠，则合并到前一段中，更新end即可
                end = Math.max(end, tempEnd);
            }
        }
        ansList.add(new int[]{start, end});
        return ansList.toArray(new int[ansList.size()][2]);
    }
}
