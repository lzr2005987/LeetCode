package com.leetcode.no51_100;

import java.util.ArrayList;
import java.util.List;

public class No73 {
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    List<Integer> pos = new ArrayList<>();
                    pos.add(i);
                    pos.add(j);
                    list.add(pos);
                }
            }
        }
        for (List<Integer> p : list) {
            int i = p.get(0);
            int j = p.get(1);
            for (int k = 0; k < matrix[0].length; k++) {
                matrix[i][k] = 0;
            }
            for (int k = 0; k < matrix.length; k++) {
                matrix[k][j] = 0;
            }
        }
    }
}
