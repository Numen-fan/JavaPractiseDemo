package com.jiajia.easy;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class MergeTwoOrderedList21 {

    public static void main(String[] args) {
        
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }

        ListNode resultNode = null; // 结果链表的头结点
        if(l1.val < l2.val) {
            resultNode = l1;
            l1 = l1.next;
        } else {
            resultNode = l2;
            l2 = l2.next;
        }

        ListNode tailNode = resultNode; // tempNode记录当前结果链表的尾节点
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                tailNode.next = l1;
                l1 = l1.next;
            } else {
                tailNode.next = l2;
                l2 = l2.next;
            }
            tailNode = tailNode.next; // 注意移动尾节点
        }
        // 处理未扫描完毕的链表
        if(l1 != null) {
            tailNode.next = l1;
        }
        if(l2 != null) {
            tailNode.next = l2;
        }
        return resultNode;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


