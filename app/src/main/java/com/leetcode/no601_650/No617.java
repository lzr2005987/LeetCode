package com.leetcode.no601_650;

public class No617 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode ans;

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }
        ans = new TreeNode();
        addTree(ans, t1, t2);
        return ans;
    }

    private void addTree(TreeNode ans, TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 != null) {
            ans.val = t2.val;
            if (ans.left == null && t2.left != null) {
                ans.left = new TreeNode();
            }
            addTree(ans.left, t1, t2.left);
            if (ans.right == null && t2.right != null) {
                ans.right = new TreeNode();
            }
            addTree(ans.right, t1, t2.right);
        } else if (t1 != null && t2 == null) {
            ans.val = t1.val;
            if (ans.left == null && t1.left != null) {
                ans.left = new TreeNode();
            }
            addTree(ans.left, t1.left, t2);
            if (ans.right == null && t1.right != null) {
                ans.right = new TreeNode();
            }
            addTree(ans.right, t1.right, t2);
        } else if (t1 != null && t2 != null) {
            ans.val = t1.val + t2.val;
            if (ans.left == null && (t1.left != null || t2.left != null)) {
                ans.left = new TreeNode();
            }
            addTree(ans.left, t1.left, t2.left);
            if (ans.right == null && (t1.right != null || t2.right != null)) {
                ans.right = new TreeNode();
            }
            addTree(ans.right, t1.right, t2.right);
        }
    }
}
