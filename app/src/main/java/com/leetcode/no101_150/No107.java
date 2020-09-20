package com.leetcode.no101_150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No107 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            bfs(queue);
            for (int i = ans.size() - 1; i >= 0; i--) {
                output.add(ans.get(i));
            }
        }
        return output;
    }

    private void bfs(Queue<TreeNode> queue) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> next = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                next.offer(node.left);
            }
            if (node.right != null) {
                next.offer(node.right);
            }
        }
        ans.add(list);
        if (!next.isEmpty()) {
            bfs(next);
        }
    }
}
