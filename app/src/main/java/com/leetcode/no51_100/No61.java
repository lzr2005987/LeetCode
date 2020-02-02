package com.leetcode.no51_100;

public class No61 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = 1;
        ListNode copy = head;
        while (copy.next != null) {
            copy = copy.next;
            len++;
        }
        copy.next = head;
        copy = copy.next;
        ListNode ans = new ListNode(0);
        ListNode ansHead = ans;
        for (int i = 0; i < len - 1; i++) {
            ans.next = new ListNode(0);
            ans = ans.next;
        }
        ans.next = ansHead;
        ListNode last = ans;
        ans = ans.next;

        k = k % len;
        for (int i = 0; i < k; i++) {
            ans = ans.next;
        }
        for (int i = 0; i < len; i++) {
            ans.val = copy.val;
            copy = copy.next;
            ans = ans.next;
        }
        last.next = null;
        return ansHead;
    }
}
