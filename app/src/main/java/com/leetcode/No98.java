package com.leetcode;

public class No98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            return true;
        }
        return isValid(root, -Double.MAX_VALUE, Double.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, double min, double max) {
        if (root.val <= min || root.val >= max) {
            return false;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null && right != null) {
            return isValid(left, min, root.val) && isValid(right, root.val, max);
        }
        if (right != null) {
            return isValid(right, root.val, max);
        }
        if (left != null) {
            return isValid(left, min, root.val);
        }
        return true;
    }
}
