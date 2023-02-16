package com.jiajia.jianzhioffer;

import com.jiajia.common.TreeNode;

public class Offer32 {

    TreeNode pre, head;

    public static void main(String[] args) {
        Offer32 o = new Offer32();
        TreeNode root = TreeNode.buildTree(new Integer[]{30, 13, null, -28, null, -44, null, null, -35});
        TreeNode head = o.treeToDoublyList(root);
        System.out.println("ss");
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }


    /**
     * 写了一堆，是错的，没有搞清楚应该用什么遍历顺序去处理。
     * @param root
     * @param parent
     * @return
     */
    public TreeNode processNode(TreeNode root, TreeNode parent) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            if (parent == null) {
                return root;
            }
            // 这是一个叶子节点了
            if (root.val < parent.val) { // 对parent而言是一个左子树的叶子节点
                root.right = parent;
            } else {
                root.left = parent;
            }
            return root; // 叶子节点都要返回
        }

        TreeNode leftLeafNode = processNode(root.left, root); // 得到左子树的叶子节点
        TreeNode rightLeafNode = processNode(root.right, root); // 得到右子树的叶子节点

        // 为左子树的叶子节点设置前驱
        if (leftLeafNode != null) {
            if (parent == null) { // 到根节点了
                leftLeafNode.left = rightLeafNode == null ? root : rightLeafNode;
                if (root.right == null) {
                    root.right = leftLeafNode;
                }
            } else if (leftLeafNode.val > parent.val) { // 没到根节点，但是parent右子树的左结点
                leftLeafNode.left = parent;
            }
        } else {
            if (parent != null) {
                root.left = parent;
            }
        }

        // 为右子树设置后驱
        if (rightLeafNode != null) {
            if (parent == null) { // 到根节点了
                rightLeafNode.right = leftLeafNode == null ? root : leftLeafNode;
                if (root.left == null) {
                    root.left = rightLeafNode;
                }
            } else if (rightLeafNode.val < parent.val) {  // 没到根节点，但是parent左子树的右叶子结点
                rightLeafNode.right = parent;
                parent.left = rightLeafNode;
            }
        } else {
            // 当前节点的右边没有了
            if (parent != null) {
                root.right = parent;
            }
        }

        if (parent == null) { // 根节点
            return leftLeafNode == null ? root : leftLeafNode;
        }

        return root.val < parent.val ? leftLeafNode : rightLeafNode;
    }

    void dfs(TreeNode cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
