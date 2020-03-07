package com.leetcode.no1_50;

import java.util.Stack;

public class No25Stack {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode ans = null, temp = null;
        while (head != null) {
            int n = 0;
            while (n < k && head != null) {
                stack.push(head);
                head = head.next;
                n++;
            }
            while (!stack.isEmpty()) {
                if (ans == null) {
                    ans = stack.peek();
                    temp = ans;
                } else {
                    temp.next = stack.pop();
                    temp = temp.next;
                }
            }
        }
        return ans;
    }
}
