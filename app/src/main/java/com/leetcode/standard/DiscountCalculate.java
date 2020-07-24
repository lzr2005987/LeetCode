package com.leetcode.standard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiscountCalculate {
    private static List<Integer> ans = new ArrayList<>();
    private static int maxDiscount;

    public static List<Integer> getDiscountEnum(List<Integer> discountList, int total) {
        for (int i = 1; i < discountList.size() + 1; i++) {
            getScheme(discountList, new ArrayList<Integer>(), 0, total, i);
        }
        return ans;
    }

    private static void getScheme(List<Integer> discountList, List<Integer> curList, int curDiscount, int total, int n) {
        if (curList.size() == n) {
            if (curDiscount > maxDiscount) {
                maxDiscount = curDiscount;
                ans = curList;
            }
            return;
        }
        for (int i = 0; i < discountList.size(); i++) {
            if (!curList.contains(i) && discountList.get(i) + curDiscount < total) {
                curList.add(i);
                List<Integer> next = new ArrayList<>(curList);
                getScheme(discountList, next, discountList.get(i) + curDiscount, total, n);
                curList.remove(curList.size() - 1);
            }
        }
    }

    public static List<Integer> getDiscountDp(List<Integer> discountList, int total) {
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


    public static List<Integer> getDiscountDpOptimize(List<Integer> discountList, int total) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        int[][] dp = new int[2][total];
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
            int pre = i % 2 == 0 ? 1 : 0;
            int cur = i % 2 == 0 ? 0 : 1;
            for (int j = 0; j < total; j++) {
                if (j >= curDiscount) {
                    if (dp[pre][j] > dp[pre][j - curDiscount] + curDiscount) {
                        dp[cur][j] = dp[pre][j];
                        if (dp[cur][j] > 0) {
                            String key = i + "" + j;
                            String prevKey = (i - 1) + "" + j;
                            map.put(key, map.get(prevKey));
                        }
                    } else {
                        dp[cur][j] = dp[pre][j - curDiscount] + curDiscount;
                        if (dp[cur][j] > 0) {
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
                    dp[cur][j] = dp[pre][j];
                    if (dp[cur][j] > 0) {
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
