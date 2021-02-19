package com.leetcode.no51_100;

public class No92 {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null, mNode = null, nNode = null;
        ListNode h = head;
        if (m == n) {
            return head;
        }
        for (int i = 1; i <= n; i++) {
            if (i == m - 1) {
                pre = h;
            } else if (i == m) {
                mNode = h;
            } else if (i == n) {
                nNode = h;
            } else if (i > n) {
                break;
            }
            h = h.next;
        }
        if (pre != null) {
            pre.next = nNode;
        } else {
            head = nNode;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode cur = mNode;
            mNode = mNode.next;
            cur.next = nNode.next;
            nNode.next = cur;
        }
        return head;
    }
}
