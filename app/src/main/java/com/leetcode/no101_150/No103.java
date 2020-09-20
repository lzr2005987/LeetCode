package com.leetcode.no101_150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class No103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            bfs(queue, 0);
        }
        return ans;
    }

    private void bfs(Queue<TreeNode> queue, int times) {
        Queue<TreeNode> next = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> curList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (times % 2 == 1) {
                stack.push(cur);
            } else {
                curList.add(cur.val);
            }
            if (cur.left != null) {
                next.offer(cur.left);
            }
            if (cur.right != null) {
                next.offer(cur.right);
            }
        }
        while (!stack.isEmpty()) {
            curList.add(stack.pop().val);
        }
        ans.add(curList);
        if (!next.isEmpty()) {
            bfs(next, times + 1);
        }
    }
}
