package com.leetcode.no351_400;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (queue.size() >= k && matrix[i][j] > queue.peek()) {
                    break;
                }
                queue.offer(matrix[i][j]);
            }
        }
        while (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
