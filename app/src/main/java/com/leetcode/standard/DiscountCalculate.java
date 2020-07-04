package com.leetcode.standard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiscountCalculate {
    public static List<Integer> getDiscountScheme(List<Integer> discountList, int total) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        int[][] dp = new int[discountList.size()][total];
        for (int i = 0; i < total; i++) {
            int firstDiscount = discountList.get(0);
            dp[0][i] = i < firstDiscount ? 0 : firstDiscount;
            if (dp[0][i] > 0) {
                String key = "0" + i;
                List<Integer> value = new ArrayList<>();
                value.add(0);
                map.put(key, value);
            }
        }
        for (int i = 1; i < discountList.size(); i++) {
            int curDiscount = discountList.get(i);
            for (int j = 0; j < total; j++) {
                if (j >= curDiscount) {
                    if (dp[i - 1][j] > dp[i - 1][j - curDiscount] + curDiscount) {
                        dp[i][j] = dp[i - 1][j];
                        if (dp[i][j] > 0) {
                            String key = i + "" + j;
                            String prevKey = (i - 1) + "" + j;
                            map.put(key, map.get(prevKey));
                        }
                    } else {
                        dp[i][j] = dp[i - 1][j - curDiscount] + curDiscount;
                        if (dp[i][j] > 0) {
                            String key = i + "" + j;
                            String prevKey = (i - 1) + "" + (j - curDiscount);
                            List<Integer> prevConstitute = map.get(prevKey);
                            if (prevConstitute == null) prevConstitute = new ArrayList<>();
                            List<Integer> value = new ArrayList<>(prevConstitute);
                            value.add(i);
                            map.put(key, value);
                        }
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (dp[i][j] > 0) {
                        String key = i + "" + j;
                        String prevKey = (i - 1) + "" + j;
                        map.put(key, map.get(prevKey));
                    }
                }
            }
        }
        String key = (discountList.size() - 1) + "" + (total - 1);
        return map.get(key);
    }

}
