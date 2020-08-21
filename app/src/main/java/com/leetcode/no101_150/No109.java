package com.leetcode.no101_150;

import java.util.ArrayList;

public class No109 {
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


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        if (list.isEmpty()) {
            return null;
        }
        TreeNode node = new TreeNode();
        generateTree(node, list);
        return node;
    }

    private void generateTree(TreeNode node, ArrayList<Integer> list) {
        int p = list.size() / 2;
        node.val = list.get(p);
        if (p > 0) {
            node.left = new TreeNode();
            generateTree(node.left, new ArrayList<Integer>(list.subList(0, p)));
        }
        if (p < list.size() - 1) {
            node.right = new TreeNode();
            generateTree(node.right, new ArrayList<Integer>(list.subList(p + 1, list.size())));
        }
    }
}
