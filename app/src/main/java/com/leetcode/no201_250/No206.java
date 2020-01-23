package com.leetcode.no201_250;

import java.util.Stack;

public class No206 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        if (head == null || head.next == null) {
            return head;
        }
        while (head != null) {
            stack.push(new ListNode(head.val));
            head = head.next;
        }
        head = stack.pop();
        head.next = stack.pop();
        ListNode res = head;
        head = head.next;
        while (!stack.isEmpty()) {
            head.next = stack.pop();
            head = head.next;
        }
        return res;
    }
}
