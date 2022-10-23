package com.jiajia.jingsai;

import com.jiajia.kit.ArrayUtils;

/**
 * Created by Numen_fan on 2022/10/23
 * Desc:
 */
public class Solution316 {

    public static void main(String[] args) {
        System.out.println(subarrayGCD2(ArrayUtils.string2IntArray("[3,15,19,19,14]"), 1));
    }


    /**
     * 6214. 判断两个事件是否存在冲突
     * @param event1
     * @param event2
     * @return
     */
    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event1[0].compareTo(event2[1]) > 0);
    }

    /**
     * 6224. 最大公因数等于 K 的子数组数目
     * @param nums  [9,3,1,2,6,3]
     * @param k 3
     * @return 4 => [3] [9,3] [6,3] [3]
     * - [9,3,1,2,6,3]
     * - [9,3,1,2,6,3]
     * - [9,3,1,2,6,3]
     * - [9,3,1,2,6,3]
     */
    public static int subarrayGCD(int[] nums, int k) {

        int ans = 0;

        int n = nums.length;

        for (int i = 0; i < n; i++) { // 以为i为开头的子数组
            if (nums[i] % k != 0) { // 开局就不支持
                continue;
            }
            int minVal = nums[i]; // 记录子数组中的最小值
            for (int j = i; j < n; j++) {
                if (nums[j] < k || nums[j] % k != 0) {
                    // 已经出现不连续子树组了
                    break;
                }

                //就看[i, j]内的子树组是否最大公约数为k
                minVal = Math.min(minVal, nums[j]);

                if (minVal == k || match(nums, i, j, k, minVal)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private static boolean match(int[] nums, int start, int end, int k, int minValue) {
        if (start == end) {
            return false;
        }

        if (start + 1 == end && nums[start] == nums[end]) {
            return minValue == k;
        }

        int a = Integer.MAX_VALUE; // 第一小
        int b = Integer.MAX_VALUE; // 第二小
        for (int i =start; i <= end; i++) {
            if (nums[i] == a) {
                continue;
            }
            if (nums[i] < a) {
                b = a;
                a = nums[i];
            } else if (nums[i] < b) {
                b = nums[i];
            }
        }

        int temp = (b == Integer.MAX_VALUE ? a  : gcd1(a, b));

        if (temp <= k || start + 1 == end) {
            return temp == k;
        }

        for (int i = start; i <= end; i++) {
            if (nums[i] % temp != 0) {
                return true;
            }
        }

        return false;

    }



    public static int gcd1(int p, int q){
        // 若q为0，则最大公约数为p

        if(q == 0) {
            return p;
        }
        int r = p % q;
        return gcd1(q, r);

    }

    public static int subarrayGCD2(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i; j < nums.length; j++) {
                temp = gcd1(temp, nums[j]); // 更新公约数
                if (temp == k) {
                    ans++;
                } else if (temp < k) {
                    break; // 后面不满足了
                }
            }
        }

        return ans;
    }
}
