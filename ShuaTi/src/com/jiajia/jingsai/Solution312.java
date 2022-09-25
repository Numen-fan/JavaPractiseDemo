package com.jiajia.jingsai;

import com.jiajia.kit.ArrayUtils;

import java.util.*;

/**
 * Created by Numen_fan on 2022/9/25
 * Desc:
 */
public class Solution312 {

    public static void main(String[] args) {
        System.out.println(longestSubarray2(ArrayUtils.string2IntArray("[311155,311155,311155,311155,311155,311155,311155,311155,201191,311155]")));

        System.out.println(goodIndices(ArrayUtils.string2IntArray("[2,1,1,1,3,4,1]"),  2));
    }

    /**
     * 6188. 按身高排序
     * @param names
     * @param heights
     * @return
     */
    public static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);

        for (int i = 0; i < names.length; i++) {
            names[i] = map.get(heights[names.length - i - 1]);
        }

        return names;

    }


    /**
     * 6189. 按位与最大的最长子数组
     * @param nums
     * @return
     */
    public static int longestSubarray(int[] nums) {
        int temp = nums[0]; // 默认为第一个元素
        int max = temp;
        int ans = 1;
        int last = 0;
        for (int i = 1; i < nums.length; i++) {
            temp &= nums[i]; // 先将位置i的元素纳入计算
            if (temp > max || (temp == max && nums[i] == nums[i - 1])) {
                max = temp; // 继续往前走
                ans = i - last + 1;
            } else { // 变小了，这时候, 需要移动窗口，怎么移动呢
                last = i;
                temp = nums[i];
                if (temp > max) {
                    max = temp;
                    ans = 1;
                }
            }
        }

        return ans;
//        while (last != i) {
////                    temp ^= ~nums[last]; // 去掉last位置的元素
//            temp = -(~(temp ^ nums[last]));
//            last++; // 向后移动一位
//            if (temp > max) { // 这个窗口内的元素大于了当前最大的值
//                max = temp;
//                ans = i - last + 1;
//                break; // 退出窗口变化
//            }
//        }
    }

    public static int longestSubarray2(int[] nums) {
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int temp = nums[i];
            for (int j = i; j < nums.length; j++) {
                temp &= nums[j];
                if (temp >= max) {
                    if (temp == max) {
                        ans = Math.max(j - i + 1, ans);
                    } else {
                        ans = j - i + 1;
                    }
                    max = temp;
                } else {
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 6190. 找到所有好下标
     * [关键时刻做出来了，呜呜呜呜]
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> goodIndices(int[] nums, int k) {

        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        if (n - k <= k) {
            return ans;
        }

        boolean last = false;
        for (int i = k; i < n - k; i++) {
            if (last && k > 1) {
                // 前一个是满足的【这一步解决掉超时啊，太难了】
                if (nums[i - 2] >= nums[i - 1] && nums[i + k] >= nums[i + k - 1]) {
                    ans.add(i);
                    last = true;
                } else {
                    last = false;
                }
                continue;

            }

            // 判断i是否是一个好下标
            boolean choose = true;
            // 判断前k个数是否是非递增的
            for (int j = i - k + 1; j < i; j++) {
                if (nums[j] > nums[j - 1]) {
                    choose = false;
                    break;
                }
            }

            if (!choose) {
                last = false; // 上一个不满足
                continue;
            }

            // 判断后面k位是否非递减
            for (int j = i + 1; j <= i + k - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    choose = false;
                    break;
                }
            }

            last = choose;

            if (choose) {
                ans.add(i);
            }
        }

        return ans;
    }



}
