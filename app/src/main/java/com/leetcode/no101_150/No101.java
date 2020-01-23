package com.leetcode.no101_150;

public class No101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymm(root.left, root.right);
    }

    private boolean isSymm(TreeNode left, TreeNode right) {
        return (left == right) || (left != null && right != null && left.val == right.val && isSymm(left.left, right.right) && isSymm(left.right, right.left));
    }
}
