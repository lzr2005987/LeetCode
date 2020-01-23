package com.leetcode.no101_150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<TreeNode> treeList = new LinkedList<>();
        List<Integer> treeLevelList = new LinkedList<>();
        treeList.add(root);
        treeLevelList.add(0);
        while (!treeList.isEmpty()) {
            TreeNode newRoot = treeList.get(0);
            treeList.remove(0);
            int level = treeLevelList.get(0);
            treeLevelList.remove(0);
            if (ans.size() - 1 < level) {
                ans.add(new ArrayList<Integer>());
            }
            ans.get(level).add(newRoot.val);

            if (newRoot.left != null) {
                treeList.add(newRoot.left);
                treeLevelList.add(level + 1);
            }
            if (newRoot.right != null) {
                treeList.add(newRoot.right);
                treeLevelList.add(level + 1);
            }
        }
        return ans;
    }
}
