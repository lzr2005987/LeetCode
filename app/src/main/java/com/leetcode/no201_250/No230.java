package com.leetcode.no201_250;

public class No230 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int n = 0;
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        search(root, k);
        return ans;
    }

    private void search(TreeNode node, int k) {
        if (node.left != null) {
            search(node.left, k);
        }
        n++;
        if (n == k) {
            ans = node.val;
        } else if (n > k) {
            return;//剪枝
        }
        if (node.right != null) {
            search(node.right, k);
        }
    }
}
