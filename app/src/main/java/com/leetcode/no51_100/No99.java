package com.leetcode.no51_100;

import java.util.ArrayList;
import java.util.List;

public class No99 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode t1 = null, t2 = null;
        int t, pos = 0;
        search(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).val < list.get(i - 1).val) {
                if (t1 == null) {
                    t1 = list.get(i - 1);
                    pos = i;
                } else {
                    t2 = list.get(i);
                }
            }
        }
        if (t2 == null) t2 = list.get(pos);
        t = t1.val;
        t1.val = t2.val;
        t2.val = t;
    }

    private void search(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        search(root.left, list);
        list.add(root);
        search(root.right, list);
    }
}
