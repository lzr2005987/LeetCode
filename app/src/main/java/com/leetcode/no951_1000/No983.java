package com.leetcode.no951_1000;

public class No983 {
    public int mincostTickets(int[] days, int[] costs) {
        if (days.length == 0) {
            return 0;
        }
        int[] ans = new int[days.length];
        ans[0] = Math.min(costs[2], Math.min(costs[0], costs[1]));
        for (int i = 1; i < days.length; i++) {
            int c1 = ans[i - 1] + costs[0];
            int c2 = find(ans, days, i, 7) + costs[1];
            int c3 = find(ans, days, i, 30) + costs[2];
            int min = Math.min(c1, c2);
            min = Math.min(min, c3);
            ans[i] = min;
        }
        return ans[ans.length - 1];
    }

    private int find(int[] ans, int[] days, int cur, int time) {
        for (int i = cur - 1; i >= 0; i--) {
            if (days[cur] - days[i] >= time) {
                return ans[i];
            }
        }
        return 0;
    }
}