package com.leetcode.contest.kickstart.g2020;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KickStart {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int num = 1; num <= t; num++) {
            String s = in.next();
            out.println("Case #" + num + ": " + kickStart(s));
        }
        in.close();
        out.close();
    }

    public static String kickStart(String s) {
        int start = 0;
        int ans = 0;
        List<Integer> listK = new ArrayList<>();
        List<Integer> listS = new ArrayList<>();
        while (start != -1) {
            start = s.indexOf("KICK", start);
            if (start != -1) {
                listK.add(start);
            }
            if (start == -1) {
                break;
            }
            start++;
        }
        start = 0;
        while (start != -1) {
            start = s.indexOf("START", start);
            if (start != -1) {
                listS.add(start);
            }
            if (start == -1) {
                break;
            }
            start++;
        }
        for (int i : listK) {
            for (int j : listS) {
                if (j > i) {
                    ans++;
                }
            }
        }
        return String.valueOf(ans);
    }
}
