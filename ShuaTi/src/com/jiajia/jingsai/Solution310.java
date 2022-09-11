package com.jiajia.jingsai;

import com.jiajia.kit.ArrayUtils;

import java.util.*;

/**
 * Created by Numen_fan on 2022/9/11
 * Desc:
 */
public class Solution310 {

    public static void main(String[] args) {

        System.out.println(partitionString("hdklqkcssgxlvehva"));

        System.out.println(minGroups(ArrayUtils.string2IntArray2("[[5,10],[6,8],[1,5],[2,3],[1,10]]")));

    }

    /**
     * 6176. 出现最频繁的偶数元素
     * @param nums
     * @return
     */
    public int mostFrequentEven(int[] nums) {

        Arrays.sort(nums);

        int cnt = 0;
        int ans = -1;

        int last = -1;
        int tempCnt = 0;
        for (int a : nums) {
            if (a % 2 == 0) {
                // 是个偶数
                if (last == a) {
                    // 一样的数
                    tempCnt++;
                } else {
                    // 出现新的偶数，那么更新结果
                    if (tempCnt > cnt) {
                        cnt = tempCnt;
                        ans = last;
                    }
                    // 开始新的计数
                    last = a;
                    tempCnt = 1;
                }
            }
        }

        if (tempCnt > cnt) {
            ans = last;
        }

        return ans;

    }

    /**
     * 需要保持有序
     * @param s
     * @return
     */
    public static int partitionString(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder chs = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String a = String.valueOf(s.charAt(i));
            if (chs.indexOf(a) != -1) {
                res.add(chs.toString());
                chs = new StringBuilder(a);
            } else {
                chs.append(a);
            }
        }

        res.add(chs.toString());

        return res.size();

    }

    /**
     * 6178. 将区间分为最少组数
     * @param intervals
     * @return
     */
    public static int minGroups(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        // 用一个有序队列进行处理，其底层是一个小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int[] a : intervals) {
            if (!queue.isEmpty() && queue.peek() < a[0]) {
                // 直接加到这一组
                queue.poll(); // 移除最小的那个
            }
            queue.add(a[1]);
        }
        return queue.size();
    }
}
