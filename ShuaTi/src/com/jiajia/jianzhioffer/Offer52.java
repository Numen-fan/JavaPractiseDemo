package com.jiajia.jianzhioffer;

import com.jiajia.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 查找两个链表相交的节点，双指针浪漫相遇的解法很精妙，可以好好参考一下。
 * https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solutions/883382/liang-ge-lian-biao-de-di-yi-ge-gong-gong-pzbs/
 */
public class Offer52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = 0;
        int bLength = 0;
        ListNode A = headA;
        ListNode B = headB;
        while (A != null) {
            aLength++;
            A = A.next;
        }

        while (B != null) {
            B = B.next;
            bLength++;
        }

        A = headA;
        B = headB;
        if (aLength == 0 || bLength == 0) {
            return null;
        }

        if (aLength > bLength) {
            int diff = aLength - bLength;
            for (int i = 0; i < diff; i++) {
                A = A.next;
            }
        } else if (aLength < bLength) {
            int diff = bLength - aLength;
            for (int i = 0; i < diff; i++) {
                B = B.next;
            }
        }

        while (A != null && B != null) {
            if (A == B) { // A 和 B是同一个节点（对象）
                return A;
            }
            A = A.next;
            B = B.next;
        }

        return null;
    }

    /**
     * 空间换取时间
     * @param headA
     * @param headB
     * @return
     */
    ListNode method1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        while (headA != null) {
            list.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (list.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
