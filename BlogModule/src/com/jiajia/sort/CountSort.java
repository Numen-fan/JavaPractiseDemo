package com.jiajia.sort;

import com.jiajia.utils.ArrayUtils;

/**
 * Created by Numen_fan on 2022/2/19
 * Desc: 计数排序
 */
public class CountSort {

    public static void main(String[] args) {
        int[] nums = {98, 97, 98, 92, 90, 93, 94, 95, 96, 96};
//        sort1(nums);

        nums = sort2(nums);

        ArrayUtils.print(nums);
    }

    /**
     * 基础用法
     */
    static void sort1(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        int[] count = new int[(max - min) + 1]; // 计数数组空间大小
        for (int num : nums) {
            count[num - min]++; // 计数
        }

        // 排序，重填原始数组
        int index = 0; // 结果数组的下标
        for (int j = 0; j < count.length; j++) { // j + min 表示原始元素值， count[j] 表示其出现次数
            while (count[j]-- > 0) { // 循环count[j]次
                nums[index++] = j + min;
            }
        }
    }

    static int[] sort2(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        int[] count = new int[(max - min) + 1]; // 计数数组空间大小

        for (int num : nums) {
            count[num - min]++; // 计数
        }

        // 对count数组进行变形，使用count[j] += count[j-1];
        // 变形之后，对于原始数组nums[j], 它在结果数组的位置下标为count[nums[j] - min]
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] result = new int[nums.length];
        for(int num : nums) { // 将每一个num放到结果数组的目标位置上。
            int index = count[num - min] - 1; // 需要减1，考数组下标0开始。
            result[index] = num;
            count[num - min]--; // 自减
        }

        return result;
    }
}
