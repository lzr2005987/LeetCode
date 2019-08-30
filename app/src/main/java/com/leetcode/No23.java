package com.leetcode;

public class No23 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        boolean flag = true;
        ListNode res = null, tmp = null;
        int min = Integer.MAX_VALUE;
        int pos = 0;
        boolean nullFlag = false;
        if (lists.length == 0) {
            return null;
        }
        for (ListNode node : lists) {
            if (node != null) {
                nullFlag = true;
            }
        }
        if (!nullFlag) {
            return null;
        }
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val <= min) {
                min = lists[i].val;
                pos = i;
            }
        }
        lists[pos] = lists[pos].next;
        tmp = new ListNode(min);
        res = tmp;

        while (flag) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val <= min) {
                    min = lists[i].val;
                    pos = i;
                }
            }
            if (lists[pos] != null) {
                lists[pos] = lists[pos].next;
                tmp.next = new ListNode(min);
                tmp = tmp.next;
            }

            flag = false;
            for (ListNode node : lists) {
                if (node != null) {
                    flag = true;
                    break;
                }
            }
        }
        return res;
    }
}
