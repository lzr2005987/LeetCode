package com.leetcode.no501_550;

public class No530 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int ans = -1;
    int last = -1;

    public int getMinimumDifference(TreeNode root) {
        if (root.left != null) {
            getMinimumDifference(root.left);
        }
        if (last == -1) {
            last = root.val;
        } else {
            if (ans == -1) {
                ans = root.val - last;
            } else {
                ans = Math.min(ans, root.val - last);
            }
            last = root.val;
        }
        if (root.right != null) {
            getMinimumDifference(root.right);
        }
        return ans;
    }
}
