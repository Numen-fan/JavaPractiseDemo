package com.jiajia.jingsai;

import com.jiajia.daily.Solution20220727;

import java.util.Arrays;

/**
 * Created by Numen_fan on 2022/7/31
 * Desc:
 */
public class Solution304 {

    public static void main(String[] args) {
        Solution304 solution304 = new Solution304();


        System.out.println(solution304.minimumOperations(new int[]{1,5,0,3,5}));

        System.out.println(solution304.closestMeetingNode(new int[]{2,2,3,-1}, 0, 1));
    }

    /**
     * 6132. 使数组中所有元素都等于零
     * @param nums
     * @return
     */
    public int minimumOperations(int[] nums) {

        int ans = 0;
        Arrays.sort(nums);


        while (true) {
            int index = 0;
            while (index < nums.length && nums[index] == 0) {
                index++;
            }

            if (index >= nums.length) {
                break;
            }

            // nums[index] 为最小的数
            ans++;

            int tp = nums[index];

            for (int i = index; i < nums.length; i++) {
                nums[i] -= tp;
            }
        }
        return ans;

    }

    /**
     * 6133. 分组的最大数量
     * @param grades
     * @return
     */
    public int maximumGroups(int[] grades) {

        int ans = 1;

        int pre = 1;
        int cur = 0;

        for (int i = 1; i < grades.length; i++) {
            cur++;
            if (cur > pre) {
                pre = cur;
                cur = 0;
                ans++;
            }
        }


        return ans;
    }

    /**
     * 6134. 找到离给定两个节点最近的节点
     * 【Error】
     * @param edges
     * @param node1
     * @param node2
     * @return
     */
    public int closestMeetingNode(int[] edges, int node1, int node2) {

        int ans = -1;

        StringBuilder sb1 = new StringBuilder();

        int index = node1;
        boolean find = false;
        while (index < edges.length && (!find || index != node1) && edges[index] != -1) {
            find = true;
            sb1.append(edges[index]);
            index = edges[index];
        }

        StringBuilder sb2 = new StringBuilder();
        find = false;
        index = node2;
        while (index < edges.length && (!find || index != node2) && edges[index] != -1) {
            find = true;
            sb2.append(edges[index]);
            index = edges[index];
        }


        char[] char1 = sb1.toString().toCharArray();

        Arrays.sort(char1);

        char[] char2 = sb2.toString().toCharArray();

        Arrays.sort(char2);

        for (int i = 0; i < char1.length; i++) {
            for (int j = 0; j < char2.length; j++) {
                if (char1[i] == char2[j]) {
                    return Integer.parseInt(String.valueOf(char1[i]));
                }
            }
        }

        return ans;

    }

}
