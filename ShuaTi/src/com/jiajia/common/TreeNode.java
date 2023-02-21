package com.jiajia.common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Numen_fan on 2022/5/4
 * Desc:
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    public static TreeNode buildTree(Integer[] nodes) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nodes[0]);
        if (nodes.length == 1) {
            return root;
        }

        queue.add(root);
        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                if (index >= nodes.length) {
                    break;
                }

                TreeNode curNode = queue.poll(); // 为这个节点分配左右节点

                if (nodes[index] != null) {
                    curNode.left = new TreeNode(nodes[index]);
                    queue.add(curNode.left);
                }

                index++;

                if (index < nodes.length) {
                    if (nodes[index] !=null) {
                        curNode.right = new TreeNode(nodes[index]);
                        queue.add(curNode.right);
                    }
                    index++;
                }
            }
        }

        return root;
    }
}
