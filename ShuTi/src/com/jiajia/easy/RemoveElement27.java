package com.jiajia.easy;
/**
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
public class RemoveElement27 {

    public static void main(String[] args) {

    }

    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        }

        // 遍历数组，填充最后一个元素
        int endIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[endIndex++] = nums[i];
            }
        }
        return endIndex;
    }
}
// @lc code=end