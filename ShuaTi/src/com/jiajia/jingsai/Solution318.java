package com.jiajia.jingsai;

import com.jiajia.kit.ArrayUtils;

import java.util.*;

/**
 * Created by Numen_fan on 2022/11/6
 * Desc:
 */
public class Solution318 {

    public static void main(String[] args) {
        ArrayUtils.print(applyOperations(ArrayUtils.string2IntArray("[1,2,2,1,1,0]")));

        System.out.println(maximumSubarraySum2(ArrayUtils.string2IntArray("[1,5,4,2,9,9,9]"), 3));

        System.out.println(totalCost(ArrayUtils.string2IntArray("[17,12,10,2,7,2,11,20,8]"), 3, 4));

        "str".replaceAll()
    }

    /**
     * 6229. 对数组执行操作
     * @param nums
     * @return
     */
    public static int[] applyOperations(int[] nums) {
        int n = nums.length;
        // i 和 i+1处理
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] << 1;
                nums[i + 1] = 0;
            }
        }

        // 移动所有的0
        int head = 0, tail = 0;
        while (tail != n) {
            if (nums[tail] != 0) {
                nums[head] = nums[tail];
                if (tail != head) {
                    nums[tail] = 0;
                }
                head++;
            }
            tail++;
        }
        return nums;
    }

    /**
     * 6230. 长度为 K 子数组中的最大和
     * @param nums
     * @param k
     * @return 【空间超限】
     */
    public static long maximumSubarraySum(int[] nums, int k) {
        long maxVal = 0;
        int n =nums.length;
        Map<Integer, Point> map = new HashMap<>();

        for (int i = 0; i <= n - k; i++) {
            Point point = map.get(i - 1);
            if (i > 0 && point != null && (!point.contains(nums[i + k - 1]) || nums[i + k - 1] == nums[i - 1])) {
                Point pp = new Point();
                pp.i = i;
                pp.sum = point.sum - nums[i - 1] + nums[i + k - 1];
                Set<Integer> ts = new HashSet<>(point.set);
                ts.remove(nums[i - 1]);
                ts.add(nums[i + k - 1]);
                pp.set = ts;
                maxVal = Math.max(maxVal, pp.sum);
                map.put(i, pp);
            } else {
                // 自己算
                long temp = 0;
                Set<Integer> set = new HashSet<>();
                for (int j = i; j < i + k; j++) {
                    boolean success = set.add(nums[j]);
                    if (!success) {
                        break;
                    }
                    temp += nums[j];
                    if (j == i + k - 1) {
                        maxVal = Math.max(maxVal, temp);
                        Point p = new Point();
                        p.i = j;
                        p.sum = temp;
                        p.set = set;
                        map.put(j, p);
                    }
                }
            }
        }
        return maxVal;
    }


    /**
     * 6230. 长度为 K 子数组中的最大和
     */
    public static long maximumSubarraySum2(int[] nums, int k) {
        // 记录滑动窗口中各个数出现的次数。
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        long temp = 0;
        // 用第一个k长度的滑动窗口去初始化
        for (int i = 0; i < k; i++) {
            int a = map.getOrDefault(nums[i], 0);
            map.put(nums[i], a + 1);
            temp += nums[i];
        }
        // 不重复的k个数
        if (map.size() == k) {
            ans = temp;
        }

        int index = k;
        while (index < nums.length) {
            // 去除滑动窗口左边的数
            int left = nums[index - k];
            map.put(left, map.get(left) - 1);
            if (map.get(left) == 0) {
                map.remove(left);
            }
            temp -= left;

            // 添加滑动窗口右边的数
            int rightCnt = map.getOrDefault(nums[index], 0);
            map.put(nums[index], rightCnt + 1);
            temp += nums[index];

            if (map.size() == k) {
                ans = Math.max(ans, temp);
            }

            index++;
        }

        return ans;
    }

    public static class Point {
        int i = 0;
        long sum = 0;
        Set<Integer> set = new HashSet<>();

        public boolean contains(int num) {
            return !set.contains(num);
        }
    }

    /**
     * 6231. 雇佣 K 位工人的总代价
     * @param costs
     * @param k
     * @param candidates
     * @return
     */
    public static long totalCost(int[] costs, int k, int candidates) {
        long ans = 0;
        for (int i = 0; i < k; i++) {
            int left = findIndex2(costs, candidates, true);
            int right = findIndex2(costs, candidates, false);
            if (costs[left] <=costs[right]) {
                ans += costs[left];
                costs[left] = -1;
            } else {
                ans += costs[right];
                costs[right] = -1;
            }
        }
        return ans;
    }

    public static int findIndex2(int[] nums, int k, boolean left) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        if (left) {
            // 从左往右
            int i = 0;
            int cnt = 0;
            while (i < nums.length && cnt < k) {
                if (nums[i] < 0) {
                    i++;
                    continue;
                }
                if (nums[i] < min) {
                    index = i;
                    min = nums[i];
                }
                i++;
                cnt++;
            }
        } else {
            // 从右往左
            // 从左往右
            int i = nums.length - 1;
            int cnt = 0;
            while (i >= 0 && cnt < k) {
                if (nums[i] < 0) {
                    i--;
                    continue;
                }
                if (nums[i] < min) {
                    index = i;
                    min = nums[i];
                }
                i--;
                cnt++;
            }
        }

        return index;
    }

}
