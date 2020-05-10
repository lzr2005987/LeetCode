package com.leetcode.no201_250;

public class No235 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return search(root, p, q);
    }

    private TreeNode search(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            return search(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return search(root.left, p, q);
        } else {
            return root;
        }
    }
}
