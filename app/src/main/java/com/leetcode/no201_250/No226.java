package com.leetcode.no201_250;

public class No226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        rotate(root);
        return root;
    }

    private void rotate(TreeNode root) {
        TreeNode t;
        t = root.left;
        root.left = root.right;
        root.right = t;
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
    }
}
