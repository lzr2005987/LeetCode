package com.leetcode.no101_150;

import java.util.Arrays;

public class No108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode ans, copy;

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        } else if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int mid = (nums.length - 1) / 2;
        ans = new TreeNode(nums[mid]);
        if (mid > 0) {
            getTree(nums, 0, mid - 1);
        }
        getTree(nums, mid + 1, nums.length - 1);
        return ans;
    }

    private void getTree(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        TreeNode copy = ans;
        putNode(copy, nums[mid]);
        if (right > left) {
            if (mid > left) {
                getTree(nums, left, mid - 1);
            }
            getTree(nums, mid + 1, right);
        }
    }

    private void putNode(TreeNode node, int n) {
        if (node.val > n) {
            if (node.left != null) {
                putNode(node.left, n);
            } else {
                node.left = new TreeNode(n);
            }
        } else {
            if (node.right != null) {
                putNode(node.right, n);
            } else {
                node.right = new TreeNode(n);
            }
        }
    }
}
