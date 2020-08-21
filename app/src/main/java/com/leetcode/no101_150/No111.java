package com.leetcode.no101_150;

import java.util.LinkedList;
import java.util.Queue;

public class No111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        return bfs(queue, 1);
    }

    private int bfs(Queue<TreeNode> cur, int depth) {
        Queue<TreeNode> queue = new LinkedList<>();
        while (!cur.isEmpty()) {
            TreeNode node = cur.poll();
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return bfs(queue, depth + 1);
    }
}
