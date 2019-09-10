package com.leetcode;

public class No104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        return calculateDepth(root, 0);
    }

    private int calculateDepth(TreeNode root, int depth) {
        return root == null ? depth : Math.max(calculateDepth(root.left, depth + 1), calculateDepth(root.right, depth + 1));
    }
}
