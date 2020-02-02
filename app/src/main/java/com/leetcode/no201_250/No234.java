package com.leetcode.no201_250;

import java.util.Stack;

public class No234 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        int len = 1;
        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
        while (fast.next != null) {
            fast = fast.next;
            len++;
            if (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
                stack.push(slow);
                len++;
            }
        }
        if (len == 1) {
            return true;
        } else if (len == 2) {
            return head.val == fast.val;
        }

        ListNode mid = slow;
        if (len % 2 == 1) {
            slow = slow.next;
        } else if (slow.val != slow.next.val) {
            return false;
        } else {
            slow = slow.next.next;
        }
        stack.pop();

        while (stack.size() > 0) {
            ListNode node = stack.pop();
            if (node.val != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
