package com.leetcode;

public class No112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sum;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        this.sum = sum;
        return search(0, root);
    }

    private boolean search(int cur, TreeNode node) {
        cur += node.val;
        if (cur == sum && node.left == null && node.right == null) {
            return true;
        } else {
            boolean left = false;
            boolean right = false;
            if (node.left != null) {
                left = search(cur, node.left);
            }
            if (node.right != null) {
                right = search(cur, node.right);
            }
            return left || right;
        }
    }
}
