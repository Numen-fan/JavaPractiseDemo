package com.jiajia.medium;

import java.util.Arrays;

public class ReconstructQueue406 {

    public static void main(String[] args) {
        int[][] people = new int[][]{{9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }

    /**
     * 思想
     * 1、先按照身高从大到小排序，这样就能保证位置i的身高一定>=它之前的身高, 身高相同的，k小的排在前面。
     * 2、然后从大到小按照k进行插入排序，直接插入到位置k处，
     *  重点【因为后面的身高比它矮，即使插入到它前面也不会对它造成任何影响】
     */
    public static int[][] reconstructQueue(int[][] people) {
        int[][] queue = new int[people.length][people[0].length];
        // 1，先按照身高进行排序
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });

        // 再进行插入排序
        for(int i = 0; i < people.length; i++) {
            int k = people[i][1]; // 第i个人插入的位置
            if (queue[k][0] == 0) {
                // 说明第k个位置还没有人，则直接插入
                queue[k] = people[i];
            } else { // 需要将queue中k及其后面的元素后移
                int lastIndex = k;
                while(queue[lastIndex][0] != 0) {
                    lastIndex++;
                }
                // lastIndex位置没有元素，将i->lastIndex - 1的元素移动
                for (int m = lastIndex; m > k; m--) {
                    queue[m] = queue[m - 1];
                }
                queue[k] = people[i];
            }
        }
        return queue;

    }

}
