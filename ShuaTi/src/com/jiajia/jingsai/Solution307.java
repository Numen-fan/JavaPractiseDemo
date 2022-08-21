package com.jiajia.jingsai;

import com.jiajia.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Numen_fan on 2022/8/21
 * Desc: 307周赛
 */
public class Solution307 {

    public static void main(String[] args) {

        Solution307 solution307 = new Solution307();

        System.out.println(solution307.minNumberOfHours(2, 4, new int[]{1}, new int[]{3}));

        System.out.println(solution307.largestPalindromic("00"));

        TreeNode root = TreeNode.buildTree(new Integer[]{1, 5, 3, null, 4, 10, 6, 9, 2});

        System.out.println(solution307.amountOfTime(root, 3));

    }

    /**
     * 6152. 赢得比赛需要的最少训练时长
     *
     * @param initialEnergy
     * @param initialExperience
     * @param energy
     * @param experience
     * @return
     */
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {

        int ans = 0;

        int cnt = Arrays.stream(energy).sum();

        if (cnt >= initialEnergy) {
            ans += cnt - initialEnergy + 1;
        }

        // 先看精力值
//        int i = 0;
//        for (; i < energy.length; i++) {
//            if (initialEnergy - energy[i] > 0) {
//                initialEnergy -= energy[i];
//                continue;
//            }
//            break;
//        }
//
//        int temp  = 0;
//        for(; i < energy.length; i++) {
//            temp += energy[i];
//        }
//
//        ans += temp - initialEnergy + 1; // 需要严格大于

        // 在算经验值
        for (int i = 0; i < experience.length; i++) {
            if (initialExperience > experience[i]) {
                initialExperience += experience[i];
                continue;
            }

            // 不够，需要补上'
            int diff = experience[i] - initialExperience + 1;
            ans += diff;
            initialExperience += (diff + experience[i]);
        }


        return ans;

    }


    /**
     * 6166. 最大回文数字
     *
     * @param num
     * @return
     */
    public String largestPalindromic(String num) {
        if (num.length() == 1) {
            return num;
        }

        int[] nums = new int[10]; // nums[i] 表示i出现的次数

        for (int i = 0; i < num.length(); i++) {
            int index = num.charAt(i) - '0';
            nums[index]++;
        }

        // 从后面往前面找，只要数量是2的倍数，就拼起来放进去

        StringBuilder sb = new StringBuilder();

        while (true) {
            // 先找偶数对字符
            int maxNum = -1;
            int i = nums.length - 1;
            boolean idDouble = false;
            for (; i >= 0; i--) {
                if (nums[i] > 0) {
                    maxNum = Math.max(maxNum, i);
                    if (nums[i] >= 2) {
                        idDouble = true;
                        break; // 找到了偶数对
                    }
                }
            }

            // 有效
            if (idDouble) {
                int cnt = (nums[i] / 2) * 2;
                char[] chars = new char[cnt];
                Arrays.fill(chars, (char) (i + '0'));
                int insertIndex = sb.length() / 2;
                sb.insert(insertIndex, String.valueOf(chars));
                nums[i] -= cnt;
            } else if (maxNum != -1) { // 单个数字
                int insertIndex = sb.length() / 2;
                sb.insert(insertIndex, maxNum);
                break;
            } else {
                break;
            }
        }

        while (sb.length() > 1 && sb.toString().startsWith("0")) {
            sb.replace(0, 1, "");
            if (sb.length() > 1) {
                sb.replace(sb.length() - 1, sb.length(), "");
            }
        }

        return sb.toString();
    }


    boolean[] node = new boolean[100001];

    /**
     * 6154. 感染二叉树需要的总时间
     *
     * @param root
     * @param start
     * @return
     */
    public int amountOfTime(TreeNode root, int start) {

        node[start] = true;

        int ans = 0;

        if (root.left == null && root.right == null) {
            return ans;
        }

        do {
            ans++;
        } while (amount(root, null));

        return ans;
    }

    /**
     * @return 是否还有未被感染的节点
     */
    public boolean amount(TreeNode root, TreeNode parent) {

        if (root == null) {
            return false;
        }

        // 当前节点的左边节点是否被感染， 如果为false，那么回来为true，表示当前节点不能被感染
        boolean originLeft = root.left != null && node[root.left.val];
        boolean originRight = root.right != null && node[root.right.val];

        boolean left = amount(root.left, root); // 左边还有未被污染的节点
        boolean right = amount(root.right, root); // 右边还有未被污染的节点

        if (!node[root.val]) {
            // 当前节点是因为父亲节点被感染而导致的
            if (parent != null && node[parent.val]) {

                node[root.val] = true;
            } else if (originRight || originLeft) { // 是因为原始左右节点被感染
                node[root.val] = true;
            }
        }

        return !node[root.val] || left || right;
    }

}
