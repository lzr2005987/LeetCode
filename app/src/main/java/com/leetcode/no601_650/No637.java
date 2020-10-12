package com.leetcode.no601_650;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No637 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Double> ans = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        bfs(queue);
        return ans;
    }

    private void bfs(Queue<TreeNode> queue) {
        Queue<TreeNode> nextQueue = new LinkedList<>();
        double sum = 0;
        int num = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sum += node.val;
            num++;
            if (node.left != null) {
                nextQueue.offer(node.left);
            }
            if (node.right != null) {
                nextQueue.offer(node.right);
            }
        }
        sum = sum / (double) num;
        ans.add(sum);
        if (!nextQueue.isEmpty()) {
            bfs(nextQueue);
        }
    }
}
