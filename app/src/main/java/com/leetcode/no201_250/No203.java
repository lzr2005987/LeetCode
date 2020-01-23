package com.leetcode.no201_250;

public class No203 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode newList = head;
        if (newList == null) {
            return null;
        }
        while (newList != null && newList.val == val) {
            head = head.next;
            newList = newList.next;
        }
        while (newList != null && newList.next != null) {
            while (newList.next != null && newList.next.val == val) {
                newList.next = newList.next.next;
            }
            newList = newList.next;
        }
        return head;
    }
}
