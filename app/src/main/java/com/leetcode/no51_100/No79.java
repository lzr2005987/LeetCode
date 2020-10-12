package com.leetcode.no51_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (find(new HashMap<Integer, List<Integer>>(), board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(HashMap<Integer, List<Integer>> map, char[][] board, String word, int i, int j, int p) {
        if (board[i][j] == word.charAt(p)) {
            HashMap<Integer, List<Integer>> copyMap = new HashMap<>(map);
            List<Integer> list = new ArrayList<>(copyMap.getOrDefault(i, new ArrayList<Integer>()));

            if (list.contains(j)) {
                return false;
            }
            if (p == word.length() - 1) {
                return true;
            }
            list.add(j);
            copyMap.put(i, list);
            boolean up, down, left, right;
            if (i > 0) {
                up = find(copyMap, board, word, i - 1, j, p + 1);
                if (up) return true;
            }

            if (j > 0) {
                left = find(copyMap, board, word, i, j - 1, p + 1);
                if (left) return true;
            }

            if (i < board.length - 1) {
                down = find(copyMap, board, word, i + 1, j, p + 1);
                if (down) return true;
            }

            if (j < board[0].length - 1) {
                right = find(copyMap, board, word, i, j + 1, p + 1);
                return right;
            }
        }
        return false;
    }
}
