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


    public static List<Integer> getDiscountDpOptimize(double c, double[] w) {
        double[][] p = new double[(int) c][2];
        int n = w.length;
        p[0][0] = 0;
        p[0][1] = 0;
        int left = 0, right = 0, next = 1;
        int[] head = new int[n + 2];
        head[n + 1] = 0;
        head[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            int k = left;
            for (int j = left; j <= right; j++) {
                if (p[j][0] + w[i] > c) {
                    break;
                }
                double nw = p[j][0] + w[i];
                double nv = p[j][1] + w[i];
                //放入比nw小的跳跃点，因为重量小的价值无论大小
                for (; k <= right && p[k][0] < nw; k++, next++) {
                    p[next][0] = p[k][0];
                    p[next][1] = p[k][1];
                }
                //如果重量相等，取价值大的跳跃点
                if (k <= right && p[k][0] == nw) {
                    if (p[k][1] > nv) {
                        nv = p[k][1];
                    }
                    k++;
                }
                //放入更新的跳跃点
                if (nv > p[next - 1][1]) {
                    p[next][0] = nw;
                    p[next][1] = nv;
                    next++;
                }
                /*去除比更新的跳跃点重量大却价值小的点，
                  由于是每一次更新完之后结果都是重量和价值都是递增的跳跃点排列
                  一旦出现价值超过当前的点，那后续的点一定都是超过的*/
                for (; k <= right && p[k][1] <= nv; k++) ;
            }
            //将后续的点放入
            for (; k <= right; k++, next++) {
                p[next][0] = p[k][0];
                p[next][1] = p[k][1];
            }
            left = right + 1;
            right = next - 1;
            head[i] = next;
        }
        return traceBack(w, p, head);
//        return p[next - 1][1];
    }

    private static List<Integer> traceBack(double[] w, double[][] p, int[] head) {
        List<Integer> trace = new ArrayList<>();
        int k = head[0] - 1;
        int n = w.length;
        for (int i = 1; i <= n; i++) {
            int left = head[i + 1];
            int right = head[i] - 1;
            for (int j = left; j <= right; j++) {
                if (p[j][0] + w[i - 1] == p[k][0] && p[j][1] + w[i - 1] == p[k][1]) {
                    k = j;
                    trace.add(i);
                    break;
                }
            }
        }
        return trace;
    }
}
