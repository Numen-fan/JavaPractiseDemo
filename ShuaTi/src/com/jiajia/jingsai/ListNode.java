package com.jiajia.jingsai;

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
}
