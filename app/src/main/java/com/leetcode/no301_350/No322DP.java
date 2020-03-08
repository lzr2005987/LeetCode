package com.leetcode.no301_350;

public class No322DP {
    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount + 1];
        count[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            int min = -1;
            for (int j = 0; j < coins.length; j++) {
                int cur = i - coins[j];
                if (cur >= 0 && count[cur] >= 0) {
                    if (min == -1) {
                        min = count[cur] + 1;
                    } else {
                        min = Math.min(min, count[cur] + 1);
                    }
                }
            }
            count[i] = min;
        }
        return count[amount];
    }
}
