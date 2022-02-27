package com.jiajia.medium;

/**
 * Created by Numen_fan on 2022/2/22
 * Desc:
 */
public class Jump45 {
    public static void main(String[] args) {
        System.out.println(jump1(new int[] {2,3,1,1,4}));
    }

    public static int jump1(int[] nums) {

        int result = 0;

        if(nums.length == 1) { // 已经在终点位置上
            return result;
        }

        int index = 0;
        while(index < nums.length) {

            if(index == nums.length - 1) {
                break;
            }
            int max = nums[index]; // 当前能跳的最长距离
            if(index + max >= nums.length - 1) {
                result++; // 说明当前的index上可以一步跳到终点
                break;
            }
            int nextIndex = -1; // 下一步的下标位置
            // 找到往后各个地方能前进的最远距离
            int tempMax = index + nums[index];
            for(int i = index + 1;  i < nums.length && i <= index + max; i++) {
                if(tempMax <  i + nums[i]) { // index + max < i + nums[i] 需要确保新跳的位置不能比现在短
                    tempMax = i + nums[i];
                    nextIndex = i;
                }
            }

            index = nextIndex;
            result++;

        }
        return result;
    }
}
