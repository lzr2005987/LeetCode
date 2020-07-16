package com.leetcode.no951_1000;

import java.util.LinkedList;
import java.util.Queue;

public class No991 {
    int ans = 0;
    boolean isEnd = false;

    public int brokenCalc(int X, int Y) {
        Queue<Integer> queue = new LinkedList<>();
        if (X == Y) {
            return 0;
        } else if (X < Y && X != 0) {
            queue.offer(2 * X);
        }
        if (2 * X >= Y) {
            queue.offer(X - 1);
        }
        search(queue, Y);
        return ans;
    }

    private void search(Queue<Integer> queue, int Y) {
        ans++;
        int size = queue.size();
        for (int i = 0; i < size && !isEnd; i++) {
            int cur = queue.poll();
            if (cur == Y) {
                isEnd = true;
                return;
            } else {
                if (cur < Y && cur != 0) {
                    queue.offer(cur * 2);
                }
                if (2 * cur >= Y) {
                    queue.offer(cur - 1);
                }
            }
        }

        if (!isEnd) {
            search(queue, Y);
        }
    }
}
