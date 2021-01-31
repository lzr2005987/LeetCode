package com.leetcode.contest.kickstart.h2020;

import java.io.PrintWriter;
import java.util.Scanner;

public class BoringNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int num = 1; num <= t; num++) {
            long left = in.nextLong();
            long right = in.nextLong();
            out.println("Case #" + num + ": " + boringNumbers(left, right));
        }
        in.close();
        out.close();
    }

    private static String boringNumbers(long left, long right) {
        long ans = 0;
        for (long i = left; i <= right; i++) {
            if (isBoring(i)) {
                ans++;
            }
        }
        return String.valueOf(ans);
    }

    private static boolean isBoring(long n) {
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int res = Integer.parseInt(String.valueOf(c));
            if ((res % 2 == 0) ^ ((i + 1) % 2 == 0)) {
                return false;
            }
        }
        return true;
    }
}
