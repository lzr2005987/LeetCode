package com.leetcode.no1_50;

public class No25Pointer {
    public static class ListNode {
        int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy, right = dummy;
        while (right != null) {
            int n = 0;
            while (n < k && right != null) {
                right = right.next;
                n++;
            }
            if (right == null) {
                break;
            }
            ListNode temp = left.next;
            while (left.next != right) {
                ListNode cur = left.next;
                left.next = cur.next;
                cur.next = right.next;
                right.next = cur;
            }
            left = temp;
            right = temp;
        }
        return dummy.next;
    }
}
