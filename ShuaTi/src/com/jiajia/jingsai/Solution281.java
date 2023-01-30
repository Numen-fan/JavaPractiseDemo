package com.jiajia.jingsai;

import com.jiajia.common.ListNode;

/**
 * Created by Numen_fan on 2022/2/20
 * Desc:
 */
public class Solution281 {

    public static void main(String[] args) {
        System.out.println(countEvent(30));

        int[] nums = {0, 1, 0, 3, 0, 2, 2, 0};

        Utils.printList(mergeNodes(Utils.buildList(nums)));

        System.out.println(coutPairs(new int[]{1,2,3,4,5}, 2));

    }

    /**
     * 6012. 统计各位数字之和为偶数的整数个数
     * 1 <= num <= 1000
     */
    static int countEvent(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            String numStr = String.valueOf(i);
            int temp = 0;
            for (int j = 0; j < numStr.length(); j++) {
                temp += numStr.charAt(j);
            }
            if (temp % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     *  6013. 合并零之间的节点
     */
    static ListNode mergeNodes(ListNode head) {
        // 1 先合并0节点之间的节点
        ListNode tempHead = head, tail = head; // 定义临时head节点，用于遍历使用，tail表示尾节点
        while (tempHead != null) { // 指向每一段左边的0
            tail = tempHead.next;
            int mergeValue = 0; // 记录两个0节点之间的累加值
            while (tail != null && tail.val != 0) {
                mergeValue += tail.val;
                tail.val = 0; // 修改当前节点val为0
                tail = tail.next; // 执行下一个节点
            }
            if (mergeValue != 0) {
                tempHead.next.val = mergeValue; // 复用tempHead的下一个节点，避免重复申请资源
            }
            tempHead = tail; // 移动tempHead到tail，开始下一段
        }

        // 2 merge结束，进行0节点删除
        head = head.next;
        tail = head;
        ListNode curNode = head.next;
        while (curNode != null) {
            if (curNode.val != 0) {
                tail.next = curNode;
                tail = curNode;
            }
            curNode = curNode.next;
            // 关键
            tail.next = null;
        }
        return head;
    }

    /**
     * 6015. 统计可以被 K 整除的下标对数目
     */
    public static long coutPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] * nums[j]) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}







