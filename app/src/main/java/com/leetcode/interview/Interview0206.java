package com.leetcode.interview;

import java.util.Stack;

public class Interview0206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode l = head;
        int len = 0;
        while (l != null) {
            len++;
            l = l.next;
        }
        boolean odd = len % 2 == 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len / 2; i++) {
            stack.push(head.val);
            head = head.next;
        }
        if (odd) {
            head = head.next;
        }
        while (head != null) {
            int peek = stack.pop();
            if (peek != head.val) {
                return false;
            } else {
                head = head.next;
            }
        }
        return true;
    }
}
