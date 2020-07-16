package com.leetcode.no901_950;

import java.util.HashMap;
import java.util.Set;

public class No914 {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        Set<Integer> set = map.keySet();
        int g = -1;
        for (int i : set) {
            if (g == -1) {
                g = map.get(i);
            } else {
                g = gcd(g, map.get(i));
            }
        }
        return g >= 2;
    }

    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
