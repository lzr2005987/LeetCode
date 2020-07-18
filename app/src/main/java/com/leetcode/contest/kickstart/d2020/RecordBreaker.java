package com.leetcode.contest.kickstart.d2020;

import java.io.PrintWriter;
import java.util.Scanner;

public class RecordBreaker {
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
            out.println("Case #" + num + ": " + recordBreaker(a));
        }
        in.close();
        out.close();
    }

    public static int recordBreaker(int[] a) {
        int max = -1;
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max && (i == a.length - 1 || a[i] > a[i + 1])) {
                ans++;
            }
            max = Math.max(max, a[i]);
        }
        return ans;
    }
}
