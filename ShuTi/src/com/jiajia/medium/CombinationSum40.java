package com.jiajia.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum40 {

    private final List<List<Integer>> result = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int sum = 0;
    private int[] used;

    public static void main(String[] args) {

        CombinationSum40 bean = new CombinationSum40();

        bean.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);

        System.out.println(bean.result);

    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        used = new int[candidates.length];

        backTracking(candidates, 0, target);

        return result;

    }

    public void backTracking(int[] candidates, int startIndex, int target) {
        if(sum == target) {
            result.add(new ArrayList(path));
            return;
        }

        if(sum > target || startIndex >= candidates.length) {
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            if(i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == 0) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = 1;
            backTracking(candidates, i + 1, target);
            sum -= candidates[i];
            used[i] = 0;
            path.remove(path.size() - 1); // 回溯
        }
    }

    private boolean containsPath() {
        List<Integer> tempPath = new ArrayList<>(path);
        Collections.sort(tempPath);
        for(List<Integer> p : result) {
            if (p.size() != tempPath.size()) {
                continue;
            }
            Collections.sort(p);
            for (int i = 0; i < p.size(); i++) {
                if (p.get(i) != tempPath.get(i)) {
                    break;
                }
                if (i == p.size() -1) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getSum(List<Integer> path) {
        int sum = 0;
        for(int a : path) {
            sum += a;
        }
        return sum;
    }

}
