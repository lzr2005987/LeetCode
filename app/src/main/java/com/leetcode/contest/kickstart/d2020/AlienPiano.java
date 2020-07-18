package com.leetcode.contest.kickstart.d2020;

import java.io.PrintWriter;
import java.util.Scanner;

public class AlienPiano {
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
            out.println("Case #" + num + ": " + alienPiano(a));
        }
        in.close();
        out.close();
    }

    public static int alienPiano(int[] a) {
        int cur = 0;
        int ans = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                cur++;
            } else if (a[i] < a[i - 1]) {
                cur--;
            }
            if (cur >= 4 || cur <= -4) {
                ans++;
                cur = 0;
            }
        }
        return ans;
    }
}
