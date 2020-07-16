package com.leetcode.no751_800;

public class No785 {
    int ans = 0;
    int totalSize = 0;

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        color[0] = 1;
        for (int i = 0; i < graph.length; i++) {
            totalSize += graph[i].length;
        }
        search(graph, color, 0);
        return ans == 1;
    }

    private void search(int[][] graph, int[] color, int cur) {
        if (totalSize <= 0) {
            ans = 1;
            return;
        }
        if (ans != 0) {
            return;
        }
        int curColor = color[cur];
        for (int i = 0; i < graph[cur].length; i++) {
            if (totalSize <= 0) {
                ans = 1;
                return;
            }
            if (ans != 0) {
                return;
            }
            if (color[graph[cur][i]] == 0) {
                color[graph[cur][i]] = curColor == 1 ? 2 : 1;
                totalSize--;
                search(graph, color, graph[cur][i]);
            } else if (color[graph[cur][i]] == curColor) {
                ans = 2;
                return;
            }
        }
    }
}
