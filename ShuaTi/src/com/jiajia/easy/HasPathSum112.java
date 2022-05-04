package com.jiajia.easy;

import com.jiajia.common.TreeNode;
import kotlin.Pair;

import java.util.Stack;

/**
 * Created by Numen_fan on 2022/5/4
 * Desc:
 */
public class HasPathSum112 {

    /**
     * 递归，先序遍历
     * @param root
     * @param targetSum
     * @return
     */
    private boolean method1(TreeNode root, int targetSum) {

        if( root == null) {
            return false;
        }

        if (root.left == null && root.right == null) { // 找到叶子节点
            return targetSum == root.val;
        }

        targetSum -= root.val;

        return method1(root.left, targetSum) || method1(root.right, targetSum);

    }

    /**
     * 迭代法，先序遍历，桟内保存的是一个node和root到这个node路径的累计和
     * @param root
     * @param targetSum
     * @return
     */
     private boolean method2(TreeNode root, int targetSum) {

         if (root == null) {
             return false;
         }

         Stack<Entry> stack = new Stack<>();

         stack.add(new Entry(root, root.val));

         while(!stack.isEmpty()) {
             Entry entry = stack.pop();

             TreeNode curNode = entry.node;

             if (curNode.left == null && curNode.right == null && targetSum == entry.sum) {
                 return true; // 叶子节点，且满足累加和的条件
             }

             if (curNode.right != null) {
                 stack.add(new Entry(curNode.right, entry.sum + curNode.right.val));
             }

             if (curNode.left != null) {
                 stack.add(new Entry(curNode.left, entry.sum + curNode.left.val));
             }

         }

         return false; // 没有找到满足条件的路径

     }

    /**
     * method2的改良版，使用Pair替换Entry
     * @param root
     * @param targetSum
     * @return
     */
    private boolean method3(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        stack.add(new Pair(root, root.val));

        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> entry = stack.pop();

            TreeNode curNode = entry.getFirst();

            if (curNode.left == null && curNode.right == null && targetSum == entry.getSecond()) {
                return true; // 叶子节点，且满足累加和的条件
            }

            if (curNode.right != null) {
                stack.add(new Pair(curNode.right, entry.getSecond() + curNode.right.val));
            }

            if (curNode.left != null) {
                stack.add(new Pair(curNode.left, entry.getSecond() + curNode.left.val));
            }
        }
        return false; // 没有找到满足条件的路径
    }

    static class Entry {
        public TreeNode node;
        public int sum; // 记录root到这个node路径上的累计和

        public Entry(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }

}
