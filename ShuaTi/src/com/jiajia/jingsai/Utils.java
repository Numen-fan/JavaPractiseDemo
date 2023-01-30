package com.jiajia.jingsai;

import com.jiajia.common.ListNode;

/**
 * Created by Numen_fan on 2022/2/20
 * Desc:
 */
public class Utils {
    public static ListNode buildList(int[] nums) {
        ListNode head = null;
        ListNode next = null;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            if (head == null) {
                head = node;
                next = head;
            } else {
                next.next = node;
                next = node;
            }
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 求两数的最大公约数
     */
    public static int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a < b) {
            if (b % a == 0) {
                return a;
            }
            return gcd(a, b % a);
        }
        return gcd(b, a);
    }
}
