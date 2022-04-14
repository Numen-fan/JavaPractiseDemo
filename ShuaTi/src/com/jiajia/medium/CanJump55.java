package com.jiajia.medium;

public class CanJump55 {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }

    static boolean canJump(int[] nums) {
        /**
         * 思路：贪心思想，在每个位置上，获取步数，在该步数范围内，跳到具备最长步数的一个位置，寻求局部最优，从而实现整体最优（尽量远的距离）
         */
        if(nums[0] == 0 && nums.length != 1) {
            return false;
        }

        int index = 0;
        while(index < nums.length) {
            if(index == nums.length - 1) {
                return true;
            }
            int max = nums[index]; // 当前能跳的最长距离
            if(index + max >= nums.length - 1) {
                return true;
            }
            int nextIndex = -1; // 下一步的下标位置
            // 找到在接下来的max步内的最大
            int tempMax = Integer.MIN_VALUE;
            for(int i = index + 1;  i < nums.length && i <= index + max; i++) {
                if(tempMax <= nums[i] && index + max < i + nums[i]) { // index + max < i + nums[i] 需要确保新跳的位置不能比现在短
                    tempMax = nums[i];
                    nextIndex = i;
                }
            }

            if(nextIndex == -1 || tempMax == 0 && nextIndex != nums.length - 1) {
                return false;
            }

            index = nextIndex;
        }
        return false;
    }

}
