package com.leetcode.no151_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return ans;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        search(queue);
        return ans;
    }

    private void search(LinkedList<TreeNode> queue) {
        LinkedList<TreeNode> next = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (queue.isEmpty()) {
                ans.add(node.val);
            }
            if (node.left != null) next.add(node.left);
            if (node.right != null) next.add(node.right);
        }
        if (!next.isEmpty()) search(next);
    }
}
