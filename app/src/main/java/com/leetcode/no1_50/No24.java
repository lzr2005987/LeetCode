package com.leetcode.no1_50;

public class No24 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode oddNode, evenNode, tmp, res = null;
        oddNode = head;
        if (head == null) {
            return null;
        }
        evenNode = head.next;
        if (evenNode == null) {
            return head;
        } else {
            tmp = new ListNode(evenNode.val);
            res = tmp;
            tmp.next = new ListNode(oddNode.val);
            tmp = tmp.next;
        }
        while (oddNode != null && evenNode != null) {
            oddNode = oddNode.next.next;
            evenNode = evenNode.next;
            if (evenNode != null) {
                if (evenNode.next != null) {
                    evenNode = evenNode.next;
                    tmp.next = new ListNode(evenNode.val);
                    tmp = tmp.next;
                    tmp.next = new ListNode(oddNode.val);
                    tmp = tmp.next;
                } else {
                    tmp.next = new ListNode(evenNode.val);
                    return res;
                }
            } else {
                return res;
            }
        }
        return res;
    }
}
