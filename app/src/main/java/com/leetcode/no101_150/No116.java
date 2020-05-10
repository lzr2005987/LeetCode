package com.leetcode.no101_150;

import java.util.LinkedList;

public class No116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        search(queue);
        return root;
    }

    private void search(LinkedList<Node> queue) {
        LinkedList<Node> next = new LinkedList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (!queue.isEmpty()) {
                node.next = queue.peek();
            }
            if (node.left != null) next.add(node.left);
            if (node.right != null) next.add(node.right);
        }
        if (!next.isEmpty()) search(next);
    }
}
