package com.jiajia.easy;

public class RemoveDuplicates26 {
    public static void main(String[] args) {

    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        }

        // int result = nums.length;
        // int temp = 0;
        // for(int i = nums.length - 1;  i >= 1; i--) {
        //     if(nums[i] != nums[i - 1]) {
        //         continue;
        //     }

        // 方案1
        // 需要做数组内元素的移动
        // 将nums[i]保存，并将i ~ lenght - 1 的元素往前移动一位。
        // 最后将nums[i]放在length - 1 的位置处（不需要啊）

        // temp = nums[i];
        // for(int j = i; j < nums.length - 1; j++) {
        //     nums[j] = nums[j + 1];
        // }
        // result--;

        // 方案2
        // 将上面的移动进行改造，向前探测，记录重复数字的次数n，以及结束的的下标i
        // 从将i+1 ~ length - 1的元素向前移动
        // 将length - 1 - n -1 ~ length - 1 赋值temp(不需要了)

        // temp = nums[i];
        // int n = 0;
        // while(i > 0 && nums[i - 1] == temp) {
        //     i--;
        //     n++;
        // }
        // for(int j = i + 1; j < nums.length - n; j++) {
        //     nums[j] = nums[j + n];
        // }
        // result -= n;
        // }
        // return result;


        // 方案3
        // LinkedHashSet<Integer> set = new LinkedHashSet<>();
        // for(int i = 0; i < nums.length; i++) {
        //     set.add(nums[i]);
        // }
        // int j = 0;
        // for(Integer k : set) {
        //     nums[j++] = k;
        // }
        // return set.size();

        // 方案4 (值得好好学习一下)
        int endIndex = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[endIndex] != nums[i]) {
                nums[++endIndex] = nums[i];
            }
        }
        return endIndex + 1;
    }
}
