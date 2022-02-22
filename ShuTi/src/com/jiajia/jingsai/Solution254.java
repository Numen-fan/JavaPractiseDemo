package com.jiajia.jingsai;

public class Solution254 {

    public static void main(String[] args) {
        for(Integer i : rearrangeArray(new int[]{5,1,4,3,2})){
            System.out.print(i + " ");
        }
    }

    /**
     * 5843. 作为子字符串出现在单词中的字符串数目
     * AC
     */
    public static int numOfStrings(String[] patterns, String word) {
        int result = 0;
        for (String str : patterns) {
            if (word.contains(str)) {
                result++;
            }
        }
        return result;
    }


    /**
     * 5832. 构造元素不等于两相邻元素平均值的数组
     * 虽然AK了，但是方法有点low啊。
     */
    public static int[] rearrangeArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) { // 找到第i个位置的值
            int temp = nums[i + 1];
            for (int j = i + 1; j < nums.length; j++) { // 从i之后的元素寻找，这里有个问题，如果这个地方找不到，如何回溯
                if(nums[i] != (i == 0 ? 0 : nums[i - 1] + nums[j]) / 2f) {
                    nums[i + 1] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
        }

        int length = nums.length;
        if (nums[length - 2] == (nums[length - 1] + nums[length - 3])/ 2f) {
            int temp = nums[length - 2];
            nums[length - 2] = nums[length - 3];
            nums[length - 3] = temp;
            return nums;
        }

        return nums;

    }




}
