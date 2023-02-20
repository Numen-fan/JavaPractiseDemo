package com.jiajia.jianzhioffer;

import com.jiajia.common.TreeNode;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 */
public class Offer68I {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < q.val) {
            return getCommonAncestor(root, p, q);
        } else {
            return getCommonAncestor(root, q, p);
        }
    }

    /**
     * p.val <= q.val
     * @param root
     * @param p
     * @param q
     * @return
     */
    TreeNode getCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val >= p.val && root.val <= q.val) {
            return root; // 找到了满足的祖先节点
        }

        if (root.val > q.val) {
            return getCommonAncestor(root.left, p, q); // 去左边找
        } else {
            return getCommonAncestor(root.right, p, q); // 去右边找
        }
    }

}
