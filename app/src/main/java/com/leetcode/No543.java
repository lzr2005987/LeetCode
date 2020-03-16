package com.leetcode;

public class No543 {
    int max = 0;
    int ans = 0;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0, right = 0;
        max = 0;
        if (root.left != null) {
            search(root.left, 1);
            left = max;
        }
        max = 0;
        if (root.right != null) {
            search(root.right, 1);
            right = max;
        }
        ans = Math.max(ans, left + right);
        if (root.left != null) {
            diameterOfBinaryTree(root.left);
        }
        if (root.right != null) {
            diameterOfBinaryTree(root.right);
        }
        return ans;
    }

    private void search(TreeNode node, int n) {
        if (node.left != null) {
            search(node.left, n + 1);
        }
        if (node.right != null) {
            search(node.right, n + 1);
        }
        max = Math.max(max, n);
    }
}
