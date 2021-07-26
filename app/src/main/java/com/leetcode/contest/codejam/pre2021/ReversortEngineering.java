package com.leetcode.contest.codejam.pre2021;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReversortEngineering {
    private static List<Integer> ansList = new ArrayList<>();
    private static boolean hasDone = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int num = 1; num <= t; num++) {
            int T = in.nextInt();
            int C = in.nextInt();
            ansList = new ArrayList<>();
            hasDone = false;
            reversortEngineering(T, C);
            if (!hasDone) {
                out.println("Case #" + num + ": IMPOSSIBLE");
            } else {
                StringBuilder ans = new StringBuilder();
                for (int i = 0; i < ansList.size(); i++) {
                    ans.append(ansList.get(i));
                    if (i < ansList.size() - 1) {
                        ans.append(" ");
                    }
                }
                out.println("Case #" + num + ": " + ans.toString());
            }
        }
        in.close();
        out.close();
    }

    private static void reversortEngineering(int t, int c) {
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i <= t; i++) {
            a.add(i);
        }
        backTrack(a, t, 0, c);
    }

    private static void backTrack(List<Integer> list, int n, int start, int c) {
        if (hasDone) {
            return;
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        if (reversort(array) == c) {
            ansList = list;
            hasDone = true;
        }
        for (int i = start + 1; i < n; i++) {
            List<Integer> cur = new ArrayList<>(list);
            Collections.swap(cur, start, i);
            backTrack(cur, n, start + 1, c);
        }
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
