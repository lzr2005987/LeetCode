package com.leetcode.contest.kickstart.h2020;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int num = 1; num <= t; num++) {
            int a = in.nextInt();
            int b = in.nextInt();
            String[] input = new String[a];
            for (int i = 0; i < a; i++) {
                input[i] = in.next();
            }
            String ans = "";
            for (int i = 0; i < b; i++) {
                int i1 = in.nextInt();
                int i2 = in.nextInt();
                int n = friends(input, i1, i2);
                ans = ans + n;
                if (i < b - 1) {
                    ans = ans + " ";
                }
            }
            out.println("Case #" + num + ": " + ans);
        }
        in.close();
        out.close();
    }

    private static int ans = 1;
    private static boolean isFin = false;

    public static int friends(String[] input, int i1, int i2) {
        ans = 1;
        isFin = false;
        i1--;
        i2--;
        List<List<Integer>> relation = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < input.length; j++) {
                if (j != i && isFriends(input[i], input[j])) {
                    cur.add(j);
                }
            }
            relation.add(cur);
        }
        List<Integer> list = new ArrayList<>(relation.get(i1));
        List<Integer> remove = new ArrayList<Integer>();
        remove.add(i1);
        search(list, remove, relation, i2, 1);
        return ans == 1 ? -1 : ans;
    }

    private static void search(List<Integer> queue, List<Integer> remove, List<List<Integer>> relation, int i2, int res) {
        if (queue.contains(i2)) {
            ans = res + 1;
            isFin = true;
            return;
        }
        if (isFin) {
            return;
        }
        List<Integer> next = new ArrayList<>();
        for (int item : queue) {
            List<Integer> relationItem = relation.get(item);
            for (int rItem : relationItem) {
                if (!next.contains(rItem)&& !remove.contains(rItem)) {
                    next.add(rItem);
                }
            }
            if (!next.isEmpty()) {
                List<Integer> newRemove = new ArrayList<>(remove);
                newRemove.add(item);
                search(next, newRemove, relation, i2, res + 1);
            }
        }
    }

    private static boolean isFriends(String s, String s1) {
        char[] chars = s.toCharArray();
        char[] chars1 = s1.toCharArray();
        for (char c : chars) {
            for (char c1 : chars1) {
                if (c == c1) {
                    return true;
                }
            }
        }
        return false;
    }

}
