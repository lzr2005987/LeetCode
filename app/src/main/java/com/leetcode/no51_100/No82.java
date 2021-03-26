package com.leetcode.no51_100;

public class No82 {
    public class ListNode {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head;
        ListNode dummy = new ListNode();
        ListNode copy = dummy;
        dummy.next = left;
        while (right.next != null) {
            if (right.next.val != left.val) {
                if (right == left) {
                    right = right.next;
                    left = left.next;
                    dummy = dummy.next;
                } else {
                    dummy.next = right.next;
                    left = right.next;
                    right = left;
                }
            } else {
                right = right.next;
            }
        }
        if (right != left) {
            dummy.next = null;
        }
        return copy.next;
    }
}
