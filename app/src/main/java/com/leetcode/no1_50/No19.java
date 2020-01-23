package com.leetcode.no1_50;

public class No19 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode lNode, rNode;
        lNode = head;
        rNode = head;
        for (int i = 0; i < n; i++) {
            rNode = rNode.next;
        }
        if (rNode == null) {
            if (lNode.next == null) {
                return null;
            } else {
                head = head.next;
            }
            return head;
        }
        while (rNode.next != null) {
            lNode = lNode.next;
            rNode = rNode.next;
        }
        lNode.next = lNode.next.next;
        return head;
    }
}
