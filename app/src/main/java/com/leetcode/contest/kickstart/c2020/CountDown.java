package com.leetcode.contest.kickstart.c2020;

import java.io.PrintWriter;
import java.util.Scanner;

public class CountDown {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int num = 1; num <= t; num++) {
            int N = in.nextInt();
            int K = in.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }
            int ans = countDown(K, a);
            out.println("Case #" + num + ": " + ans);
        }
        in.close();
        out.close();
    }

    static int solve(int k, int[] array) {
        int ans = 0, cur = 0;
        for (int i = 0; i < array.length; i++) {
            int a = array[i];
            if (a == k) {
                cur = k;
            } else if (a == cur - 1) {
                cur = a;
                if (a == 1) {
                    ++ans;
                }
            } else {
                cur = 0;
            }
        }
        return ans;
    }

    private static int countDown(int k, int[] a) {
        int i = 0;
        int ans = 0;
        while (i < a.length) {
            boolean flag = true;
            if (a[i] == k) {
                flag = false;
                int cur = k;
                while (i < a.length && a[i] == cur && cur > 0) {
                    i++;
                    cur--;
                }
                if (cur == 0) ans++;
            }
            if (flag) i++;
        }
        return ans;
    }
}
