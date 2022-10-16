package com.jiajia.jingsai;

import com.jiajia.kit.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Numen_fan on 2022/10/16
 * Desc:
 */
public class Solution315 {

    public static void main(String[] args) {
        System.out.println(findMaxK(ArrayUtils.string2IntArray("[-1,2,-3,3]")));

        System.out.println(sumOfNumberAndReverse(181));

        System.out.println(countSubarrays(ArrayUtils.string2IntArray("[35054,398719,945315,945315,820417,945315,35054,945315,171832,945315,35054,109750,790964,441974,552913]"), 35054, 945315));
    }

    /**
     * 6204. 与对应负数同时存在的最大正整数
     * @param nums
     * @return
     */
    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            int t = nums[i];
            if (t <= 0) {
                break;
            }
            // 判断 -t 是否在数组中
            for (int j = 0; j < nums.length && nums[j] <0; j++) {
                if (nums[j] + t == 0) {
                    return t;
                }
            }
        }

        return -1;
    }

    /**
     * 6205. 反转之后不同整数的数目
     * @param nums
     * @return
     */
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            set.add(reverseNum(num));
        }

        return set.size();
    }

    private static int reverseNum(int num) {
        String str = new StringBuilder(String.valueOf(num)).reverse().toString();
        return Integer.parseInt(str);
    }

    /**
     * 6219. 反转之后的数字和
     * @param num
     * @return
     */
    public static boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            if (i + reverseNum(i) == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * 6207. 统计定界子数组的数目
     * @param nums
     * @param minK
     * @param maxK
     * @return
     * https://leetcode.cn/problems/count-subarrays-with-fixed-bounds/solutions/1895734/fen-xi-ding-jie-zi-shu-zu-de-xing-zhi-yi-qusi/
     */
    public static long countSubarrays(int[] nums, int minK, int maxK) {

        long l = -1; // 表示坐标不满足的下标
        int r1 = -1, r2 = -1;
        long ans = 0; // 结果

        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] > maxK || nums[i] < minK) {
                l = i; // 表示不能越过l
            }

            if(nums[i] == maxK) {
                r2 = i;
            }

            if (nums[i] == minK) {
                r1 = i;
            }

            ans += Math.max(0, Math.min(r2, r1) - l);
        }

        return ans;

    }

}
