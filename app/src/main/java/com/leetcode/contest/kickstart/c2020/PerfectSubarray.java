package com.leetcode.contest.kickstart.c2020;

import java.io.PrintWriter;
import java.util.Scanner;

public class PerfectSubarray {
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
            out.println("Case #" + num + ": " + perfectSubarray(a));
        }
        in.close();
        out.close();
    }

    private static int perfectSubarray(int[] a) {
        int sum = 0;
        int ans = 0;
        int[] sumA = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            sumA[i] = sum;
        }
        for (int i = sumA.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                int cur;
                if (j == -1) {
                    cur = sumA[i];
                } else {
                    cur = sumA[i] - sumA[j];
                }
                if (Math.round(Math.sqrt(cur)) == Math.sqrt(cur)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
