package com.leetcode.no751_800;

public class No785 {
    private int ans = 0;
    private int totalSize = 0;

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        totalSize = graph.length;
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                totalSize--;
            }
            search(graph, color, i);
            if (ans != 0) return ans == 1;
        }
        return ans == 1;
    }

    private void search(int[][] graph, int[] color, int cur) {
        if (ans == 2) {
            return;
        } else if (totalSize <= 0) {
            ans = 1;
            return;
        }

        int curColor = color[cur];
        for (int i = 0; i < graph[cur].length; i++) {
            if (color[graph[cur][i]] == 0) {
                color[graph[cur][i]] = curColor == 1 ? 2 : 1;
                totalSize--;
                search(graph, color, graph[cur][i]);
                if (ans == 2) {
                    return;
                }
            } else if (color[graph[cur][i]] == curColor) {
                ans = 2;
                return;
            }
        }
    }
}