package com.leetcode.no201_250;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class No211 {
    class TreeNode {
        char value;
        boolean isEnd = false;
        ArrayList<TreeNode> children = new ArrayList<>();

        public TreeNode(char c) {
            this.value = c;
        }
    }

    private TreeNode root;
    private boolean isEqual;

    /**
     * Initialize your data structure here.
     */
    public No211() {
        root = new TreeNode(' ');
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
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
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        boolean contain;
        TreeNode copy = root;
        Queue<TreeNode> list = new LinkedList<>();
        list.add(copy);
        isEqual = false;
        searchAns(word, 0, list);
        return isEqual;
    }

    private void searchAns(String word, int pos, Queue<TreeNode> node) {
        if (isEqual) {
            return;
        }
        Queue<TreeNode> nextList = new LinkedList<>();
        char c = word.charAt(pos);
        while (!node.isEmpty()) {
            TreeNode treeNode = node.poll();
            for (TreeNode searchNode : treeNode.children) {
                if (c == '.') {
                    nextList.offer(searchNode);
                } else if (searchNode.value == c) {
                    nextList.offer(searchNode);
                    break;
                }
            }
        }
        if (pos == word.length() - 1 && !nextList.isEmpty()) {
            for (TreeNode ansNode : nextList) {
                if (ansNode.isEnd) {
                    isEqual = true;
                    return;
                }
            }
        } else if (pos < word.length() - 1 && !nextList.isEmpty()) {
            searchAns(word, pos + 1, nextList);
        }
    }
}
