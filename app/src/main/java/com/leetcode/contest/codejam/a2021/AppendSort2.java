package com.leetcode.contest.codejam.a2021;

import java.io.PrintWriter;
import java.util.Scanner;

public class AppendSort2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int num = 1; num <= t; num++) {
            int N = in.nextInt();
            String[] a = new String[N];
            for (int i = 0; i < N; i++) {
                a[i] = String.valueOf(in.nextInt());
            }
            out.println("Case #" + num + ": " + appendSort(a));
        }
        in.close();
        out.close();
    }

    public static int appendSort(String[] a) {
        int ans = 0;
        if (a.length <= 1) {
            return 0;
        }
        int len = a.length;
        for (int i = 1; i < len; i++) {
            String n = a[i];
            String m = a[i - 1];
            if (compare(n, m) == 0) {
                continue;
            }
            int ns = n.length();
            int ms = m.length();
            int subSize = ms - ns;
            if (subSize == 0) {
                ans++;
                a[i] = a[i] + "0";
                continue;
            }
            String mf = m.substring(0, ns);
            String mr = m.substring(ns);

            if (compare(n, mf) == 2 || (compare(n, mf) == 1 && allNine(mr))) {
                subSize++;
                for (int j = 0; j < subSize; j++) {
                    a[i] = a[i] + "0";
                }
            } else if (compare(n, mf) == 1) {
                a[i] = a[i] + plusOne(mr);
            } else {
                for (int j = 0; j < subSize; j++) {
                    a[i] = a[i] + "0";
                }
            }
            ans += subSize;
        }
        return ans;
    }

    private static boolean allNine(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '9') {
                return false;
            }
        }
        return true;
    }

    private static String plusOne(String s) {
        return String.valueOf(Integer.parseInt(s) + 1);
    }

    private static int compare(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return 0;
        } else if (s1.length() < s2.length()) {
            return 2;
        }
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int i1 = Integer.parseInt(String.valueOf(chars[i]));
            int i2 = Integer.parseInt(String.valueOf(chars1[i]));
            if (i1 > i2) {
                return 0;
            } else if (i1 < i2) {
                return 2;
            }
        }
        return 1;
    }
}
