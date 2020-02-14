package com.leetcode.no301_350;

public class No337 {
    int max = 0;

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        int sum1 = 0;//在不取下一层，而取下下层的情况下获得的最大金额
        int sum2 = 0;//在取下一层的节点的情况下获得的最大金额

        if (root != null && root.val < 0) {
            return -root.val;
        } else if (root == null) {
            return 0;
        }
        if (root.left != null) {
            sum2 += rob(root.left);
            if (root.left.left != null) {
                sum1 += rob(root.left.left);
            }
            if (root.left.right != null) {
                sum1 += rob(root.left.right);
            }
        }
        if (root.right != null) {
            sum2 += rob(root.right);
            if (root.right.left != null) {
                sum1 += rob(root.right.left);
            }
            if (root.right.right != null) {
                sum1 += rob(root.right.right);
            }
        }

        root.val = -Math.max(sum2, root.val + sum1);
        return -root.val;
    }
}
