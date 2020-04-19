package com.leetcode.interview;

public class Interview1603 {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double[] ans = new double[2];
        double x1a = start1[0], y1a = start1[1], x2a = end1[0], y2a = end1[1];
        double x1b = start2[0], y1b = start2[1], x2b = end2[0], y2b = end2[1];
        if (x1a > x2a) {
            double t = x1a;
            x1a = x2a;
            x2a = t;
            t = y1a;
            y1a = y2a;
            y2a = t;
        }
        if (x1b > x2b) {
            double t = x1b;
            x1b = x2b;
            x2b = t;
            t = y1b;
            y1b = y2b;
            y2b = t;
        }

        boolean k1Flag = x2a - x1a == 0;
        boolean k2Flag = x2b - x1b == 0;
        double k1 = 0, k2 = 0;
        if (!k1Flag) {
            k1 = (y2a - y1a) / (x2a - x1a);
        }
        if (!k2Flag) {
            k2 = (y2b - y1b) / (x2b - x1b);
        }
        double b1 = y1a - k1 * x1a;
        double b2 = y1b - k2 * x1b;
        if (k1Flag && !k2Flag) {
            double inX = x1a;
            double inY = inX * k2 + b2;
            if (inX >= x1a && inX >= x1b && inX <= x2a && inX <= x2b &&
                    inY >= Math.min(y1a, y2a) && inY <= Math.max(y1a, y2a) &&
                    inY >= Math.min(y1b, y2b) && inY <= Math.max(y1b, y2b)) {
                ans[0] = inX;
                ans[1] = inY;
                return ans;
            } else {
                return new double[]{};
            }
        } else if (!k1Flag && k2Flag) {
            double inX = x1b;
            double inY = inX * k1 + b1;
            if (inX >= x1a && inX >= x1b && inX <= x2a && inX <= x2b &&
                    inY >= Math.min(y1a, y2a) && inY <= Math.max(y1a, y2a) &&
                    inY >= Math.min(y1b, y2b) && inY <= Math.max(y1b, y2b)) {
                ans[0] = inX;
                ans[1] = inY;
                return ans;
            } else {
                return new double[]{};
            }
        } else if (k1Flag && k2Flag) {
            if (x1a != x1b) {
                return new double[]{};
            }
            if (y1a > y2a) {
                double t = x1a;
                x1a = x2a;
                x2a = t;
                t = y1a;
                y1a = y2a;
                y2a = t;
            }
            if (y1b > y2b) {
                double t = x1b;
                x1b = x2b;
                x2b = t;
                t = y1b;
                y1b = y2b;
                y2b = t;
            }
            double inX = x1a;
            double inY = Math.max(y1a, y1b);
            if (inY >= y1a && inY >= y1b && inY <= y2a && inY <= y2b) {
                ans[0] = inX;
                ans[1] = inY;
                return ans;
            } else {
                return new double[]{};
            }
        }
        if (k1 == k2 && b1 != b2) {
            return new double[]{};
        } else if (k1 == k2 && b1 == b2) {
            if (x1a < x1b) {
                if (x1b > x2a) {
                    return new double[]{};
                } else {
                    ans[0] = x1b;
                    ans[1] = y1b;
                    return ans;
                }
            } else if (x1a == x1b) {
                ans[0] = x1a;
                ans[1] = y1a;
                return ans;
            } else {
                if (x1a > x2b) {
                    return new double[]{};
                } else {
                    ans[0] = x1a;
                    ans[1] = y1a;
                    return ans;
                }
            }
        } else {
            double inX = (b2 - b1) / (k1 - k2);
            double inY = k1 * inX + b1;
            if (inX >= x1a && inX >= x1b && inX <= x2a && inX <= x2b &&
                    inY >= Math.min(y1a, y2a) && inY <= Math.max(y1a, y2a) &&
                    inY >= Math.min(y1b, y2b) && inY <= Math.max(y1b, y2b)) {
                ans[0] = inX;
                ans[1] = inY;
                return ans;
            } else {
                return new double[]{};
            }
        }
    }
}
