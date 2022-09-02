package com.jiajia.daily;

import com.jiajia.common.TreeNode;

/**
 * Created by Numen_fan on 2022/9/2
 * Desc:687. 最长同值路径
 */
public class Solution20220902 {

    int ans = 0; // 全局保存最大的路径长度值

    public static void main(String[] args) {

        Solution20220902 solution20220902 = new Solution20220902();

        Integer[] data = new Integer[]{1,4,5,4,4,null,5};

        TreeNode root = TreeNode.buildTree(data);

        System.out.println(solution20220902.longestUnivaluePath(root));

    }


    public int longestUnivaluePath(TreeNode root) {

        postOrder(root);


        return ans;

    }

    private int postOrder(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int len = 0;

        int left = postOrder(root.left); // 左侧的遍历
        int right = postOrder(root.right); // 右侧的遍历

        if (root.left != null && root.left.val == root.val) {
            left++;
        } else {
            left = 0;
        }

        if (root.right != null && root.right.val == root.val) {
            right++;
        } else {
            right = 0;
        }

        len = right + left;

        ans = Math.max(len, ans);

        return Math.max(left, right);

    }



}
