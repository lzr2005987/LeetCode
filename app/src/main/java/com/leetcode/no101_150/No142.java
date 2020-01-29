package com.leetcode.no101_150;

import java.util.ArrayList;

public class No142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        while (head.next != null) {
            if (list.contains(head)) {
                return head;
            } else {
                list.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
