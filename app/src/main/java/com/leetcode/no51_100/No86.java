package com.leetcode.no51_100;

public class No86 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode copy = head;
        ListNode leftNode = null, rightNode = null;
        ListNode leftCopy = null, rightCopy = null;
        while (copy != null) {
            if (copy.val < x) {
                if (leftNode == null) {
                    leftNode = new ListNode(copy.val);
                    leftCopy = leftNode;
                } else {
                    leftNode.next = new ListNode(copy.val);
                    leftNode = leftNode.next;
                }
            } else {
                if (rightNode == null) {
                    rightNode = new ListNode(copy.val);
                    rightCopy = rightNode;
                } else {
                    rightNode.next = new ListNode(copy.val);
                    rightNode = rightNode.next;
                }
            }
            copy = copy.next;
        }
        if (leftNode != null) {
            leftNode.next = rightCopy;
            return leftCopy;
        } else {
            return rightCopy;
        }
    }
}
