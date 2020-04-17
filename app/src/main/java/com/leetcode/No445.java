package com.leetcode;

import java.util.Stack;

public class No445 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int up = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int i = 0;
            if (!stack1.isEmpty()) i = stack1.pop();
            int j = 0;
            if (!stack2.isEmpty()) j = stack2.pop();
            int cur = (i + j + up) % 10;
            up = (i + j + up) / 10;
            if (ans == null) {
                ans = new ListNode(cur);
            } else {
                ListNode node = new ListNode(cur);
                node.next = ans;
                ans = node;
            }
        }
        if (up > 0) {
            ListNode node = new ListNode(up);
            node.next = ans;
            ans = node;
        }
        return ans;
    }
}
