package com.leetcode.no751_800;

public class No783 {
    private int cur = -1;
    private int min = Integer.MAX_VALUE;

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

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return root.val;
        }
        search(root);
        return min;
    }

    private void search(TreeNode root) {
        if (root.left != null) {
            search(root.left);
        }
        if (cur >= 0) {
            min = Math.min(min, root.val - cur);
        }
        cur = root.val;
        if (root.right != null) {
            search(root.right);
        }
    }
}
