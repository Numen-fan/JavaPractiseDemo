package com.jiajia.jingsai;

import java.util.Arrays;

/**
 * Created by Numen_fan on 2022/7/10
 * Desc:
 */
public class Solution301 {

    public static void main(String[] args) {

        Solution301 solution301 = new Solution301();

        System.out.println(solution301.fillCups(new int[] {5,4,4}));

        System.out.println(solution301.canChange("R_R","__R"));

    }

    /**
     * 6112. 装满杯子需要的最短总时长
     * @param amount
     * @return
     */
    public int fillCups(int[] amount) {

        if (amount.length <= 0) {
            return amount.length;
        }

        if (amount.length == 1) {
            return amount[0];
        }

        int ans = 0;
        Arrays.sort(amount); // 从小到大排序
        if (amount[amount.length - 1] == 0) {
            return ans;
        }
        do {
            ans++;
            for (int i = amount.length - 1; i >= amount.length - 2; i--) {
                amount[i] = --amount[i];
            }
            Arrays.sort(amount); // 从小到大排序
        } while (amount[amount.length - 1] > 0);

        return ans;


    }

    /**
     * 6114. 移动片段得到字符串
     * @param start
     * @param target
     * @return
     */
    public boolean canChange(String start, String target) {

        if (!start.replace("_", "").equals(target.replace("_", "")))
            return false;

        int n = start.length();

        int i = 0, j = 0;

        while (i < n && j < n) {

            while (i < n && start.charAt(i) == '_') {
                i++;
            }

            while (j < n && target.charAt(j) == '_') {
                j++;
            }

            if (i < n && j < n && start.charAt(i) != target.charAt(j)) {
                // 因为LR是不能换顺序的，所以最后一定不可以相同了
                return false;
            }

            if (i >= n && j < n || i < n && j >= n) {
                return false;
            }

            // 如果是i位置是L，那么如果start中左侧的_小于target，那么就不可能通过移动实现了，target中是不能移动的
            // 如果是i位置是R，那么如果start中左侧的_大于target，那么就不可能通过移动实现了，target中是不能移动的
            if ((i < n && start.charAt(i) == 'L' && i < j) || (i < n && start.charAt(i) == 'R' && i > j)) {
                return false;
            }

            i++;
            j++;
        }

        return true;



    }


    /**
     * 6113. 无限集中的最小数字
     */
    static class SmallestInfiniteSet {

        int[] nums = new int[1001];


        public SmallestInfiniteSet() {
            Arrays.fill(nums, 1);
        }

        public int popSmallest() {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 1) {
                    nums[i] = 0;
                    return i;
                }
            }
            return 0;
        }

        public void addBack(int num) {
            nums[num] = 1;
        }
    }





}
