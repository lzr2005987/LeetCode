package com.leetcode.contest.codejam.pre2021;

import java.io.PrintWriter;
import java.util.Scanner;

public class MoonsAndUmbrellas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int num = 1; num <= t; num++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();
            int ans = moonsAndUmbrellas(x, y, s);
            out.println("Case #" + num + ": " + ans);
        }
        in.close();
        out.close();
    }

    private static int moonsAndUmbrellas(int x, int y, String s) {
        int ans = 0;
        int i = 0, j = 0;
        char[] chars = s.toCharArray();
        while (i < s.length() && j < s.length()) {
            char c = chars[j];
            if (c == '?') {
                j++;
            } else {
                if (i == j) {
                    i++;
                    j++;
                } else {
                    Character start = null, end = null;
                    if (i > 0) {
                        start = chars[i - 1];
                    }
                    end = chars[j];
                    if (start == null) {
                        start = end;
                    }
                    char replace;
                    if (start.equals(end)) {
                        replace = start;
                    } else if (x > y) {
                        if ('J' == start) {
                            replace = 'C';
                        } else {
                            replace = 'J';
                        }
                    } else {
                        if ('C' == start) {
                            replace = 'C';
                        } else {
                            replace = 'J';
                        }
                    }
                    for (int k = i; k < j; k++) {
                        chars[k] = replace;
                    }
                    j++;
                    i = j;
                }
            }
        }
        ans = getSum(chars, i, x, y);
        return ans;
    }

    private static int getSum(char[] chars, int i, int x, int y) {
        int ans = 0;
        for (int k = 1; k < i; k++) {
            if (chars[k] != chars[k - 1]) {
                if (chars[k] == 'J') {
                    ans += x;
                } else {
                    ans += y;
                }
            }
        }
        return ans;
    }
}
