package com.jiajia.jingsai;

import com.jiajia.common.TreeNode;
import com.jiajia.kit.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Numen_fan on 2022/11/20
 * Desc:
 */
public class Solution320 {

    public static void main(String[] args) {

        System.out.println(unequalTriplets(ArrayUtils.string2IntArray("[4,4,2,4,3]")));

        Integer[] data = new Integer[]{6,2,13,1,4,9,15,null,null,null,null,null,null,14};

        closestNodes(TreeNode.buildTree(data), Arrays.asList(2,5,16));
    }


    public static int unequalTriplets(int[] nums) {
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[i] == nums[j]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] != nums[k] && nums[j] != nums[k]) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 6242. 二叉搜索树最近节点查询
     * @param root
     * @param queries
     * @return
     */
    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap();

        dfs(root, treeMap);

        for (int a : queries) {
            Integer min = treeMap.floorKey(a);
            Integer max = treeMap.ceilingKey(a);
            ans.add(Arrays.asList(null == min ? -1 : min, null == max ? -1 : max));
        }
        System.out.println(ans);
        return ans;
    }

    private static void dfs(TreeNode node, TreeMap<Integer, Integer> list) {
        if (node.left != null) {
            dfs(node.left, list);
        }
        list.put(node.val, node.val);
        if (node.right != null) {
            dfs(node.right, list);
        }
    }
}


