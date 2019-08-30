package com.leetcode;

public class No50 {
    private double result = 0;

    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / x * pow(1 / x, -(n + 1));//注意这里
        } else {
            return pow(x, Math.abs(n));
        }
    }

    private double pow(double x, int n) {
        switch (n) {
            case 0:
                return 1;
            case 1:
                return x;
            case 2:
                return x * x;
            default:
                if (n % 2 == 1) {
                    result = pow(pow(x, n / 2), 2) * x;
                } else {
                    result = pow(pow(x, n / 2), 2);
                }
        }
        return result;
    }
}

