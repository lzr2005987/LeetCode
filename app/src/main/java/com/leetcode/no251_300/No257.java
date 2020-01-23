package com.leetcode.no251_300;

import java.util.ArrayList;
import java.util.List;

public class No257 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<String>();
        }
        search(root, "");
        return res;
    }

    private void search(TreeNode node, String sb) {
        sb = sb + node.val;
        if (node.left != null) {
            sb = sb + "->";
            search(node.left, sb);
        }
        if (node.right != null) {
            if (node.left == null) {
                sb = sb + "->";
            }
            search(node.right, sb);
        }
        if (node.left == null && node.right == null) {
            res.add(sb);
        }
    }
}
