package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

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
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        LinkedList<Integer> height = new LinkedList<>();
        treeNodes.add(root);
        height.add(1);
        while (!treeNodes.isEmpty()) {
            TreeNode newRoot = treeNodes.poll();
            int newLevel = height.poll();
            if (newRoot.left == null && newRoot.right == null) {
                return newLevel;
            }
            if (newRoot.left != null) {
                treeNodes.add(newRoot.left);
                height.add(newLevel + 1);
            }
            if (newRoot.right != null) {
                treeNodes.add(newRoot.right);
                height.add(newLevel + 1);
            }
        }
        return 0;
    }
}
