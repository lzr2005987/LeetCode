package com.leetcode.no201_250;

import java.util.ArrayList;

public class No208 {
    class TreeNode {
        char value;
        boolean isEnd = false;
        ArrayList<TreeNode> children = new ArrayList<>();

        public TreeNode(char c) {
            this.value = c;
        }
    }

    private TreeNode root;

    /**
     * Initialize your data structure here.
     */
    public No208() {
        root = new TreeNode(' ');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        boolean contain;
        TreeNode copy = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            contain = false;
            for (TreeNode child : copy.children) {
                if (child.value == c) {
                    copy = child;
                    contain = true;
                    break;
                }
            }
            if (!contain) {
                copy.children.add(new TreeNode(c));
                copy = copy.children.get(copy.children.size() - 1);
            }
        }
        copy.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        boolean flag;
        TreeNode copy = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            flag = false;
            for (TreeNode child : copy.children) {
                if (child.value == c) {
                    copy = child;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return copy.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        boolean flag;
        TreeNode copy = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            flag = false;
            for (TreeNode child : copy.children) {
                if (child.value == c) {
                    copy = child;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
