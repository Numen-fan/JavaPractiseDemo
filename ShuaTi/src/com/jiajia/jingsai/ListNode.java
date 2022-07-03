package com.jiajia.jingsai;

import java.util.List;

/**
 * Created by Numen_fan on 2022/2/20
 * Desc: 链表节点定义
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode buildList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode();

        head.val = arr[0];

        ListNode tail = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            tail.next = node;
            tail = node;
        }

        return head;
    }

}
