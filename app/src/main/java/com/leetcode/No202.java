package com.leetcode;

import java.util.HashMap;

public class No202 {
    public boolean isHappy(int n) {
        int sum = n;
        HashMap<Integer, Boolean> map = new HashMap<>();
        while (sum != 1) {
            String s = String.valueOf(sum);
            sum = 0;
            char[] chars = s.toCharArray();
            for (char c : chars) {
                int num = Integer.parseInt(String.valueOf(c));
                sum = sum + (num * num);
            }
            if (map.containsKey(sum)) {
                return false;
            } else {
                map.put(sum, true);
            }
        }
        return true;
    }
}
