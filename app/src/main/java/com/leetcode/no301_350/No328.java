package com.leetcode.no301_350;

public class No328 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        int step = 2;
        while (fast != null) {
            for (int i = 0; i < step; i++) {
                if (fast == null) {
                    return head;
                } else {
                    fast = fast.next;
                    if (i < step - 1) {
                        pre = pre.next;
                    }
                }
            }
            if (fast == null) {
                return head;
            }
            ListNode nextNode = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            pre.next = nextNode;
            slow = slow.next;
            pre = fast;
            step++;
        }
        return head;
    }
}
