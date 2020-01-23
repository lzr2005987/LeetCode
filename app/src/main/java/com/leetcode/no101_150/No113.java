package com.leetcode.no101_150;

import java.util.ArrayList;
import java.util.List;

public class No113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sum;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return result;
        }
        this.sum = sum;
        List<Integer> list = new ArrayList<Integer>();
        search(0, root, list);
        return result;
    }

    private void search(int cur, TreeNode node, List<Integer> list) {
        cur += node.val;
        list.add(node.val);
        if (cur == sum && node.left == null && node.right == null) {
            result.add(list);
        } else {
            if (node.left != null) {
                search(cur, node.left, new ArrayList<Integer>(list));
            }
            if (node.right != null) {
                search(cur, node.right, new ArrayList<Integer>(list));
            }
        }
    }
}
