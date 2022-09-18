package com.jiajia.jingsai;

import com.jiajia.common.TreeNode;
import com.jiajia.common.Trie;
import com.jiajia.kit.ArrayUtils;

import java.util.*;

/**
 * Created by Numen_fan on 2022/9/18
 * Desc:
 */
public class Solution311 {

    public static void main(String[] args) {

        TreeNode root = TreeNode.buildTree(new Integer[]{0,1,2,0,0,0,0,1,1,1,1,2,2,2,2});


        reverseOddLevels(root);

        Solution311 solution311 = new Solution311();

        ArrayUtils.print(solution311.sumPrefixScores(new String[]{"abc", "ab", "bc", "b"}));


    }

    /**
     * 6180. 最小偶倍数
     * @param n
     * @return
     */
    public static int smallestEvenMultiple(int n) {
        while (n % 2 != 0) {
            n *= 2;
        }

        return  n;
    }

    /**
     * 6181. 最长的字母序连续子字符串的长度
     * @param s
     * @return
     */
    public static int longestContinuousSubstring(String s) {
        char[] chars = s.toCharArray();

        int ans = 1;
        int len = 0;
        char last = ' ';

        for (char ch : chars) {
            if(ch - last == 1) {
                len++;
            } else {
                ans = Math.max(len, ans);
                len = 1;
            }
            last = ch;
        }

        return Math.max(ans, len);

    }


    /**
     * 6182. 反转二叉树的奇数层
     * @param root
     * @return
     */
    public static TreeNode reverseOddLevels(TreeNode root) {

        // 用层次遍历来处理
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = -1;

        while (!queue.isEmpty()) {
            // 处理新的一层
            int cnt = queue.size();
            level++;
            boolean change = level % 2 != 0; // 当前是否是奇数层
            TreeNode[] nodes = new TreeNode[cnt];
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                nodes[i] = node; // 用于待会儿反转值
                // 先将node的左右子数入队列
                assert node != null;
                if (node.left != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            // 如果当前是奇数层，需要交换
            if (change) {
                for (int j = 0; j < cnt / 2; j++) {
                    int temp = nodes[j].val;
                    nodes[j].val = nodes[cnt - j - 1].val;
                    nodes[cnt - j - 1].val = temp;
                }
            }
        }

        return root;
    }

    /**
     * 错误的实现，这样的方式打乱了偶数层
     * @param root
     * @param curLevel
     * @return
     */
    private static TreeNode reverse(TreeNode root, int curLevel) {
        if (root == null) {
            return root;
        }

        // 处理左边子树
        TreeNode left = reverse(root.left, curLevel + 1);

        // 处理右子树
        TreeNode right  = reverse(root.right, curLevel + 1) ;

        // 处理当前节点
        // 1 如果是偶数层，直接交换左右子树
        // 2 如果是奇数层，交换左右子树后，需要把值换回来
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        if (curLevel % 2 != 0 && root.left != null) {
            int leftValue = root.left.val;
            root.left.val = root.right.val;
            root.right.val = leftValue;
        }

        return root;
    }


    /**
     * 6183. 字符串的前缀分数和
     * @param words
     * @return
     */

    public int[] sumPrefixScores(String[] words) {
        int[] ans = new int[words.length];
        int index = 0;
        Trie trie = new Trie(); // 字典树的root节点
        for (String word : words) {
            trie.insert(word);
        }

        for (String word : words) {
            ans[index++] = trie.searchPrefix(word);
        }
        return ans;
    }

    Map<String, Integer> map = new HashMap<>();

    /**
     * 暴力求解，超时
     * @param words
     * @return
     */
    private int[] sumPrefixScores1(String[] words) {
        int n = words.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int cnt = word.length();
            int last = 0;
            for (int j = 1; j <= word.length(); j++) {
                String subWord = word.substring(0, j); // 得到一个前缀
                if (map.containsKey(subWord)) {
                    cnt += map.get(subWord);
                } else {
                    int t = last == 1 ? 1 : getCnt(words, subWord); // 说明只有自己满足了，其它的串不需要看了
                    cnt += t;
                    map.put(subWord, t);
                    last = t;
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }

    private int getCnt(String[] words, String subStr) {
        int sum = 0;
        for (String word : words) {
            if (word.startsWith(subStr)) {
                sum++;
            }
        }
        return sum;

    }

}
