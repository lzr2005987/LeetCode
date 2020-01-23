package com.leetcode.no101_150;

public class No129 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getNum("", root);
        return sum;
    }

    private void getNum(String num, TreeNode node) {
        if (node.left == null && node.right == null) {
            sum += Integer.parseInt(num + node.val);
        } else {
            num = num + node.val;
            if (node.left != null) {
                getNum(num, node.left);
            }
            if (node.right != null) {
                getNum(num, node.right);
            }
        }
    }
}
