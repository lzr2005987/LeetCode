package com.leetcode.interview;

import java.util.HashSet;

public class Interview0201 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode ans = new ListNode(0);
        ListNode ansCopy = ans;
        while (head != null) {
            int size = set.size();
            set.add(head.val);
            if (size < set.size()) {
                ansCopy.next = new ListNode(head.val);
                ansCopy = ansCopy.next;
            }

            head = head.next;
        }
        return ans.next;
    }
}
