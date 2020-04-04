package com.leetcode.interview;

public class Interview54 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int ans = 0;
    boolean isEnd = false;
    int n = 0;

    public int kthLargest(TreeNode root, int k) {
        search(root, k);
        return ans;
    }

    private void search(TreeNode root, int k) {
        if (isEnd) {
            return;
        }
        if (root.right != null) {
            search(root.right, k);
        }
        n++;
        if (n == k) {
            ans = root.val;
            isEnd = true;
        }
        if (root.left != null) {
            search(root.left, k);
        }
    }
}
