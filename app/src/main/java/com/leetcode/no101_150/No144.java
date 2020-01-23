package com.leetcode.no101_150;

import java.util.ArrayList;
import java.util.List;

public class No144 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        } else {
            return traversal(list, root);
        }
    }

    private List<Integer> traversal(List<Integer> list, TreeNode root) {
        list.add(root.val);
        if (root.left != null) {
            traversal(list, root.left);
        }
        if (root.right != null) {
            traversal(list, root.right);
        }
        return list;
    }
}
