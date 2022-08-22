package com.jiajia.daily;

import com.jiajia.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 655.输出二叉树
 */
public class Solution20220822 {

    int height = 0;
    String[][] res = null;

    public static void main(String[] args) {
        Solution20220822 solution20220822 = new Solution20220822();

        TreeNode root = TreeNode.buildTree(new Integer[] {1,2,3,null,4});

        System.out.println(solution20220822.printTree(root));

    }

    public List<List<String>> printTree(TreeNode root) {

        height = getTreeHeight(root) - 1;

        int m = height + 1;
        int n = (int) Math.pow(2, m) - 1;

        res = new String[m][n];

        int rootCol = (n - 1) >> 1;
        res[0][rootCol] = String.valueOf(root.val);

        calNode(root.left, 1, true, rootCol);
        calNode(root.right, 1, false, rootCol);

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(res[i][j] == null ? "" : res[i][j]);
            }
            ans.add(list);
        }

        return ans;

    }

    private int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right));
    }

    /**
     * 将当前节点放到矩阵中
     * @param root
     * @param level 当前节点所在层
     * @param left 是否在父节点的左边
     * @param parentCol 父节点所在列
     */
    private void calNode(TreeNode root, int level, boolean left, int parentCol) {

        if(root == null) {
            return;
        }

        int col;

        if (left) {
            col = parentCol - (int)Math.pow(2, height - level);
        } else {
            col = parentCol + (int)Math.pow(2, height - level);
        }

        res[level][col] = String.valueOf(root.val);

        // 开始下一层的遍历
        calNode(root.left, level + 1, true, col);
        calNode(root.right, level + 1, false, col);
    }
}
