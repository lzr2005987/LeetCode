package com.leetcode.no1_50;

public class No21 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result, tmp;
        if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 == null && l2 == null) {
            return null;
        } else {
            if (l1.val < l2.val) {
                result = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                result = new ListNode(l2.val);
                l2 = l2.next;
            }
            tmp = result;
        }

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null && l1.val < l2.val) {
                tmp.next = new ListNode(l1.val);
                tmp = tmp.next;
                l1 = l1.next;
            } else if (l1 != null && l2 != null && l1.val >= l2.val) {
                tmp.next = new ListNode(l2.val);
                tmp = tmp.next;
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                tmp.next = new ListNode(l1.val);
                tmp = tmp.next;
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                tmp.next = new ListNode(l2.val);
                tmp = tmp.next;
                l2 = l2.next;
            }
        }
        return result;
    }
}
