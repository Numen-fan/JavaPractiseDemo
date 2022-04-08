package com.jiajia.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }

    // 全局变量
    private static List<List<Integer>> result = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates); // 从下到大排一下序

        blockTracing(candidates, 0, target);

        return result;

    }

    private static void blockTracing(int[] canidates, int startIndex, int target) {
        if(getSum(path) == target) { // 满足了
            result.add(new ArrayList(path)); // 新建对象
            return; // 退出本次循环
        }

        if (getSum(path) > target) { // 已经不满足了
            return;
        }

        for (int i = startIndex; i < canidates.length; i++) {
            path.add(canidates[i]);
            if(getSum(path) > target) { // 剪枝
                path.remove(path.size() - 1); // 需要删除刚添加进去的这个元素
                return;
            }
            blockTracing(canidates, i, target);
            path.remove(path.size() - 1); // 回溯
        }
    }

    private static int getSum(List<Integer> path) {
        int sum = 0;
        for(int a : path) {
            sum += a;
        }
        return sum;
    }


}
