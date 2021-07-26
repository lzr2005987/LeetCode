package com.leetcode.contest.codejam.pre2021;

import java.io.PrintWriter;
import java.util.Scanner;

public class Reversort {
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
            int ans = reversort(a);
            out.println("Case #" + num + ": " + ans);
        }
        in.close();
        out.close();
    }

    private static int reversort(int[] a) {
        int ans = 0;
        for (int i = 0; i < a.length - 1; i++) {
            int j = getMinPos(i, a);
            ans += j - i + 1;
            if (j > i) {
                a = reverse(a, i, j);
            }
        }
        return ans;
    }

    private static int[] reverse(int[] a, int i, int j) {
        while (i < j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
        return a;
    }

    private static int getMinPos(int i, int[] a) {
        int min = i;
        for (int j = i; j < a.length; j++) {
            if (a[min] > a[j]) {
                min = j;
            }
        }
        return min;
    }
}
