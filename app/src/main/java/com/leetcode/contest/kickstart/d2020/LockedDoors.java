package com.leetcode.contest.kickstart.d2020;

import java.io.PrintWriter;
import java.util.Scanner;

public class LockedDoors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int num = 1; num <= t; num++) {
            int N = in.nextInt();
            int K = in.nextInt();
            int[] a = new int[N - 1];
            for (int i = 0; i < N - 1; i++) {
                a[i] = in.nextInt();
            }
            int[] s = new int[K];
            int[] k = new int[K];
            for (int i = 0; i < K; i++) {
                s[i] = in.nextInt();
                k[i] = in.nextInt();
            }
            String output = "";
            int[] ans = lockedDoors(a, s, k);
            for (int item : ans) {
                output = output + item + " ";
            }
            out.println("Case #" + num + ": " + output.substring(0, output.length() - 1));
        }
        in.close();
        out.close();
    }

    public static int[] lockedDoors(int[] a, int[] s, int[] k) {
        int[] ans = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            boolean[] b = new boolean[a.length];
            int si = s[i] - 1;
            int ki = k[i] - 1;
            for (int j = 0; j < ki; j++) {
                int left = -1, right = -1;
                for (int pos = si; pos < a.length; pos++) {
                    if (!b[pos]) {
                        right = pos;
                        break;
                    }
                }
                for (int pos = si - 1; pos >= 0; pos--) {
                    if (!b[pos]) {
                        left = pos;
                        break;
                    }
                }
                if (left == -1 && right == -1) {
                    ans[i] = si + 1;
                    break;
                } else if (left == -1) {
                    si = right + 1;
                    b[right] = true;
                } else if (right == -1) {
                    si = left;
                    b[si] = true;
                } else {
                    if (a[left] >= a[right]) {
                        si = right + 1;
                        b[right] = true;
                    } else {
                        si = left;
                        b[si] = true;
                    }
                }
                if (j == ki - 1) {
                    ans[i] = si + 1;
                }
            }
            if (ki == 0) {
                ans[i] = s[i];
            }
        }
        return ans;
    }
}