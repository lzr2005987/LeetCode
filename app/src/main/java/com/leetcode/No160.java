package com.leetcode;

import java.util.HashSet;

public class No160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<>();
        if(headA==headB){
            return headA;
        }
        while (headA != null || headB != null) {
            if (hashSet.contains(headA)) {
                return headA;
            } else if (hashSet.contains(headB)) {
                return headB;
            }
            if (headA != null) {
                hashSet.add(headA);
                headA = headA.next;
            }
            if (headB != null) {
                if (hashSet.contains(headB)) {
                    return headB;
                }
                hashSet.add(headB);
                headB = headB.next;
            }
        }
        return null;
    }
}
