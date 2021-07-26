package com.leetcode.contest.codejam.a2021;

import java.io.PrintWriter;
import java.util.Scanner;

public class AppendSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int num = 1; num <= t; num++) {
            int N = in.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }
            out.println("Case #" + num + ": " + appendSort(a));
        }
        in.close();
        out.close();
    }

    public static int appendSort(int[] a) {
        int ans = 0;
        if (a.length <= 1) {
            return 0;
        }
        int len = a.length;
        for (int i = 1; i < len; i++) {
            int n = a[i];
            int m = a[i - 1];
            if (n > m) {
                continue;
            }
            int ns = getSize(n);
            int ms = getSize(m);
            int subSize = ms - ns;
            if (subSize == 0) {
                ans++;
                a[i] = a[i] * 10;
                continue;
            }
            int mf = getFirst(m, getSize(n));
            int mr = getRest(m, getSize(n));

            if (n < mf || (n == mf && getSize(mr) < getSize(mr + 1))) {
                subSize++;
                a[i] = a[i] * (int) Math.pow(10, subSize);
            } else if (n == mf) {
                a[i] = a[i] * (int) Math.pow(10, subSize) + mr + 1;
            } else {
                a[i] = a[i] * (int) Math.pow(10, subSize);
            }
            ans += subSize;
        }
        return ans;
    }

    private static int getSize(int n) {
        String s = String.valueOf(n);
        return s.length();
    }

    private static int getFirst(int n, int size) {
        String s = String.valueOf(n);
        String sub = s.substring(0, size);
        return Integer.parseInt(sub);
    }

    private static int getRest(int n, int size) {
        String s = String.valueOf(n);
        String sub = s.substring(size);
        return Integer.parseInt(sub);
    }
}
