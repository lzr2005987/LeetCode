package com.leetcode.no301_350;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 按一个维度排序，另一个维度最长上升子序列
 */
public class No354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        int[] ans = new int[envelopes.length];
        ans[0] = 1;
        int maxAns = 1;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 1; i < envelopes.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] != envelopes[j][0]) {
                    max = Math.max(max, ans[j] + 1);
                }
            }
            ans[i] = max;
            maxAns = Math.max(maxAns, ans[i]);
        }
        return maxAns;
    }
}
