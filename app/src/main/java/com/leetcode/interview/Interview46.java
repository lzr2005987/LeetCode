package com.leetcode.interview;

public class Interview46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] ans = new int[s.length()];
        ans[0] = 1;
        if (s.length() == 1) {
            return 1;
        }
        ans[1] = Integer.valueOf(s.substring(0, 2)) <= 25 && Integer.valueOf(s.substring(0, 2)) >= 10 ? 2 : 1;
        for (int i = 2; i < s.length(); i++) {
            int n = Integer.valueOf(s.substring(i - 1, i + 1));
            boolean b = n <= 25 && n >= 10;
            if (b) {
                ans[i] = ans[i - 1] + ans[i - 2];
            } else {
                ans[i] = ans[i - 1];
            }
        }
        return ans[s.length() - 1];
    }
}
