package com.leetcode.no1001_1050;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 大顶堆
 */
public class No1046 {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int s : stones) {
            queue.offer(s);
        }
        while (queue.size() > 1) {
            Integer s1 = queue.poll();
            Integer s2 = queue.poll();
            if (s1 == null || s2 == null) {
                break;
            }
            int abs = Math.abs(s1 - s2);
            if (abs != 0) {
                queue.offer(abs);
            }
        }
        if (queue.isEmpty()) {
            return 0;
        } else {
            return queue.poll();
        }
    }
}
