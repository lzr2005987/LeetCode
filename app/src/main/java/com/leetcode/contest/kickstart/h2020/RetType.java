package com.leetcode.contest.kickstart.h2020;

import java.io.PrintWriter;
import java.util.Scanner;

public class RetType {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int num = 1; num <= t; num++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int s = in.nextInt();
            out.println("Case #" + num + ": " + retType(n, k, s));
        }
        in.close();
        out.close();
    }

    private static String retType(int n, int k, int s) {
        int ans1 = (k - s) + (n - s);
        int ans2 = 1 + n;
        int ans = Math.min(ans1, ans2) + k - 1;
        return String.valueOf(ans);
    }
}
