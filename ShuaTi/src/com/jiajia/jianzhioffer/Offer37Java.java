package com.jiajia.jianzhioffer;

import com.jiajia.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Offer37Java {

    private static final String NULL_NODE = "null";

    public static void main(String[] args) {
        var o = new Offer37Java();
        TreeNode root = TreeNode.buildTree(new Integer[]{1,2,3,null,null,4,5});
        String data = o.serialize(root);
        System.out.println(data);
        o.deserialize(data);
    }

    /**
     * 这里不限制返回的字符串格式，你自己能够识别就ok了
     */
    String serialize(TreeNode root)  {
        if (root == null) {
            return NULL_NODE;
        }
        StringBuilder sb = new StringBuilder();
        // 广度遍历
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            // 处理这一层的节点
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.pop(); // 取出当前节点
                if (node == null) {
                    sb.append(NULL_NODE).append(",");
                } else {
                    sb.append(node.val).append(",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    TreeNode deserialize(String data){
        if (NULL_NODE.equals(data)) {
            return null;
        }
        // 仍然采用宽度优先遍历去做
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        if (nodes.length == 1) {
            return root;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        var index = 1; // 下一个字符

        while (!queue.isEmpty() && index < nodes.length) {
            int cnt = queue.size();
            // 为这一层的节点设置左右节点
            for (int i = 0; i < cnt; i++) {
                if (index >= nodes.length) {
                    break;
                }
                var curNode = queue.poll();
                // 为当前节点设置左节点
                if (!nodes[index].equals(NULL_NODE)) {
                    assert curNode != null;
                    curNode.left = new TreeNode(Integer.parseInt(nodes[index]));
                    queue.offer(curNode.left); // 加到队列中，后面为他设置左右节点
                }

                index++; // 这里必须加一个

                if (index < nodes.length) {
                    // 为当前节点设置右节点
                    if (!nodes[index].equals(NULL_NODE)) {
                        curNode.right = new TreeNode(Integer.parseInt(nodes[index]));
                        queue.offer(curNode.right);
                    }
                    index++; // 需要在这里+1
                }
            }
        }
        return root;
    }
}
