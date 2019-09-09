package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No94 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        } else {
            return traversal(list, root);
        }
    }

    private List<Integer> traversal(List<Integer> list, TreeNode root) {
        if (root.left != null) {
            traversal(list, root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            traversal(list, root.right);
        }
        return list;
    }
}
