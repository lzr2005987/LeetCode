package com.leetcode.no151_200;

import java.util.ArrayList;

public class No173 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ArrayList<Integer> minList = new ArrayList<>();
    int pos = 0;
    int len = 0;

    public No173(TreeNode root) {
        if (root != null) {
            middleIterate(root);
        }
    }

    private void middleIterate(TreeNode node) {
        if (node.left != null) {
            middleIterate(node.left);
        }
        minList.add(node.val);
        len++;
        if (node.right != null) {
            middleIterate(node.right);
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return minList.get(pos++);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return pos < len;
    }
}
