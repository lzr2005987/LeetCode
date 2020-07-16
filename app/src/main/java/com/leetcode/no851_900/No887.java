package com.leetcode.no851_900;

import java.util.HashMap;

public class No887 {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int superEggDrop(int K, int N) {
        int key = N * 100 + K;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (N == 0) {
            map.put(key, 0);
            return 0;
        } else if (K == 1) {
            map.put(key, N);
            return N;
        }
        int left = 1, right = N;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            int f2 = superEggDrop(K, N - mid);
            int f1 = superEggDrop(K - 1, mid - 1);
            if (f1 < f2) {
                left = mid;
            } else if (f1 > f2) {
                right = mid;
            } else {
                left = right = mid;
            }
        }
        int leftAns = Math.max(superEggDrop(K, N - left), superEggDrop(K - 1, left - 1));
        int rightAns = Math.max(superEggDrop(K, N - right), superEggDrop(K - 1, right - 1));
        int ans = 1 + Math.min(leftAns, rightAns);
        map.put(key, ans);
        return ans;
    }
}
