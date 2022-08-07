package com.jiajia.jingsai;

import java.util.*;

/**
 * Created by Numen_fan on 2022/8/7
 * Desc:
 */
public class Solution305 {

    public static void main(String[] args) {

        Solution305 solution305 = new Solution305();

        System.out.println(solution305.arithmeticTriplets(new int[]{4, 5, 6, 7, 8, 9}, 2));

        System.out.println(solution305.reachableNodes(7, new int[][]{{0, 1}, {0, 2}, {0, 5}, {0, 4}, {3, 2}, {6, 5}}, new int[]{4, 2, 1}));

    }

    /**
     * 6136. 算术三元组的数目
     *
     * @param nums
     * @param diff
     * @return
     */
    public int arithmeticTriplets(int[] nums, int diff) {

        int ans = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j] - nums[i] > diff) {
                    break;
                }
                if (nums[j] - nums[i] < diff) {
                    continue;
                }
                // nums[j] - nums[i] == diff
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] - nums[j] > diff) {
                        break;
                    }
                    if (nums[k] - nums[j] < diff) {
                        continue;
                    }

                    // nums[k] - nums[j] ==diff
                    ans++;
                    break;

                }
            }
        }

        return ans;

    }


    /**
     * 6139. 受限条件下可到达节点的数目
     *
     * @param n
     * @param edges
     * @param restricted
     * @return
     */
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        return reachableNodesMethod1(n, edges, restricted); // 从0开始的可达节点数量
    }


    /**
     * 用桟模拟
     * @param n
     * @param edges
     * @param restricted
     * @return
     */
    private int reachableNodesMethod1(int n, int[][] edges, int[] restricted) {

//        Queue<Integer> queue = new LinkedList<>();

        Stack<Integer> queue = new Stack<>();

        boolean[] rest = new boolean[n];
        boolean[] paths = new boolean[n];

        Map<Integer, List<Integer>> map = new HashMap<>();

        // 构造图，记录每个节点可到的节点集合, 十分关键啊
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        for (int j : restricted) {
            rest[j] = true;
        }


        int ans = 1;
        queue.add(0);
        paths[0] = true;

        while (!queue.isEmpty()) {
            int curNode = queue.pop(); // 取出可达节点
            // 拿curNode到edges中去寻找可达节点
            List<Integer> nodes = map.get(curNode);
            if (nodes == null) {
                continue;
            }

            for (int next : nodes) {
                if (!paths[next] && !rest[next]) {
                    queue.add(next);
                    ans++;
                    paths[next] = true;
                }
            }
        }

        return ans;
    }

    /**
     * 6137. 检查数组是否存在有效划分
     * @param nums
     * @return
     */
    public boolean validPartition(int[] nums) {

        // 动态规划
        boolean[] dp = new boolean[nums.length + 1]; // dp[i + 1] 表示0 ~ i是否有效

        // 初始化
        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] && nums[i] == nums[i - 1]
                    || i >= 2 && dp[i - 2] && ((nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2])
                              || (nums[i] - nums[i - 1] == 1 && nums[i - 1] - nums[i - 2] == 1))) {
                dp[i + 1] = true;
            }
        }

        return dp[nums.length];

    }



}
