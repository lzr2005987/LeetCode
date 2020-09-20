package com.leetcode.no401_450;

public class No404 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        leftSum(root, false);
        return sum;
    }

    private void leftSum(TreeNode node, boolean isLeft) {
        if (node.left == null && node.right == null && isLeft) {
            sum += node.val;
        } else {
            if (node.left != null) {
                leftSum(node.left, true);
            }
            if (node.right != null) {
                leftSum(node.right, false);
            }
        }
    }
}
