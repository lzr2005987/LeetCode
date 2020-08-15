package com.leetcode.no101_150;

import java.util.ArrayList;
import java.util.List;

public class No133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private List<Node> nodes = new ArrayList<>();
    private Node ans = new Node();

    public Node cloneGraph(Node node) {
        clone(ans, node);
        return ans;
    }

    private void clone(Node copy, Node node) {
        List<Node> list = new ArrayList<>();
        copy.val = node.val;
        copy.neighbors = list;
        for (Node cur : node.neighbors) {
            Node n = new Node();
            n.val = cur.val;
            list.add(n);
            if (!nodes.contains(cur)) {
                nodes.add(cur);
                clone(n, cur);
            }
        }
    }
}
