package com.leetcode.no101_150;

import java.util.List;

public class No120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int ans = Integer.MAX_VALUE;
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        } else if (triangle.size() == 2) {
            return Math.min(triangle.get(0).get(0) + triangle.get(1).get(0),
                    triangle.get(0).get(0) + triangle.get(1).get(1));
        }
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            list.set(0, list.get(0) + triangle.get(i - 1).get(0));
            if (i == triangle.size() - 1) {
                ans = Math.min(ans, list.get(0));
            }
            list.set(list.size() - 1, list.get(list.size() - 1) + triangle.get(i - 1).get(list.size() - 2));
            if (i == triangle.size() - 1) {
                ans = Math.min(ans, list.get(list.size() - 1));
            }
            for (int j = 1; j < list.size() - 1; j++) {
                int min = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
                list.set(j, min + list.get(j));
                if (i == triangle.size() - 1) {
                    ans = Math.min(ans, list.get(j));
                }
            }
        }
        return ans;
    }
}
