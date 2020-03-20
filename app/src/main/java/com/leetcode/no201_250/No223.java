package com.leetcode.no201_250;

public class No223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int width = 0;
        if (Math.min(C, G) > Math.max(A, E)) {
            width = Math.min(C, G) - Math.max(A, E);
        }
        int height = 0;
        if (Math.min(D, H) > Math.max(B, F)) {
            height = Math.min(D, H) - Math.max(B, F);
        }
        int area = width * height;
        return (C - A) * (D - B) + (G - E) * (H - F) - area;
    }
}
