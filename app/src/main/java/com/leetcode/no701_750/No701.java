package com.leetcode.no701_750;

public class No701 {
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        TreeNode node = find(root, val);
        if (node.val >= val) {
            node.left = new TreeNode(val);
        } else {
            node.right = new TreeNode(val);
        }
        return root;
    }

    private TreeNode find(TreeNode node, int val) {
        if (node.val >= val) {
            if (node.left == null) {
                return node;
            } else {
                return find(node.left, val);
            }
        } else {
            if (node.right == null) {
                return node;
            } else {
                return find(node.right, val);
            }
        }
    }
}
