package com.leetcode.no301_350;

import java.util.LinkedList;
import java.util.Queue;

public class No322BFS {
    Queue<Integer> queue = new LinkedList<>();
    int res = 0;
    boolean isEnd = false;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        queue.offer(amount);
        search(queue, coins, res);
        return res;
    }

    private void search(Queue<Integer> queue, int[] coins, int n) {
        int size = queue.size();
        for (int j = 0; j < size && !isEnd; j++) {
            int num = queue.poll();
            for (int i = 0; i < coins.length; i++) {
                int sub = num - coins[i];
                if (sub == 0) {
                    isEnd = true;
                    res = n + 1;
                    return;
                }
                if (sub > 0) {
                    queue.offer(sub);
                }
            }
        }
        if (queue.isEmpty()) {
            res = -1;
            isEnd = true;
            return;
        }
        if (!isEnd) {
            search(queue, coins, n + 1);
        }
    }
}
