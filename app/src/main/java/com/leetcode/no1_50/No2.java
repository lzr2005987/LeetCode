package com.leetcode.no1_50;

import java.util.ArrayList;

public class No2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void add() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);

        ListNode l2 = new ListNode(0);
        addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3;
        ArrayList<Integer> list = new ArrayList<>();
        int a = 0, b = 0, c = 0;
        boolean flag = false;
        do {
            if (l1 == null) {
                a = 0;
            } else {
                a = l1.val;
            }
            if (l2 == null) {
                b = 0;
            } else {
                b = l2.val;
            }
            if (flag) {
                c = a + b + 1;
            } else {
                c = a + b;
            }
            if (c >= 10) {
                c = c % 10;
                flag = true;
            } else {
                flag = false;
            }
            list.add(c);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        } while (l1 != null || l2 != null);
        if (flag) {
            list.add(1);
        }
        ListNode temp = new ListNode(0);
        l3 = temp;
        for (int i = 0; i < list.size(); i++) {
            temp.val = list.get(i);
            if (i < list.size() - 1) {
                temp.next = new ListNode(0);
            }
            temp = temp.next;
        }
        return l3;
    }

}
