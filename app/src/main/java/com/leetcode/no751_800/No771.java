package com.leetcode.no751_800;

import java.util.HashSet;

public class No771 {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (set.contains(c)) {
                ans++;
            }
        }
        return ans;
    }
}
