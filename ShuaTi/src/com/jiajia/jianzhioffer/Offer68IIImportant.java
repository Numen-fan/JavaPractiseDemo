package com.jiajia.jianzhioffer;

import com.jiajia.common.TreeNode;

/**
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 */
public class Offer68IIImportant {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 找到了p q中某个节点，p q 本身或许就是祖先节点
        if (root == null || root == p || root == q) {
            return root;
        }

        // 后序遍历
        var left = lowestCommonAncestor(root.left, p, q); // 去左边找p或者q
        var right = lowestCommonAncestor(root.right, p, q); // 去右边找p或者q

        if(left != null && right != null) {
            return root; // 说明在root的左右找到了目标节点，那么root就是祖先节点
        }

        return  left == null ? right : left;

    }

}
