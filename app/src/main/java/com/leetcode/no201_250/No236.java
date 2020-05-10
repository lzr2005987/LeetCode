package com.leetcode.no201_250;

public class No236 {
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
        left = false;
        right = false;
        boolean b1 = judge(root.left, p, q);
        left = false;
        right = false;
        boolean b2 = judge(root.right, p, q);
        if (!b1 && !b2) {
            return root;
        } else if (b1) {
            return search(root.left, p, q);
        } else {
            return search(root.right, p, q);
        }
    }

    boolean left, right;

    private boolean judge(TreeNode cur, TreeNode p, TreeNode q) {
        if (left && right) return true;
        if (cur == null) return false;
        if (!left && cur == p) {
            left = true;
        } else if (!right && cur == q) {
            right = true;
        }
        return judge(cur.left, p, q) || judge(cur.right, p, q);
    }
}
