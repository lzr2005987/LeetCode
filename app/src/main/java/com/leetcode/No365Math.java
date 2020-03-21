package com.leetcode;

/**
 * 祖贝定理：ax+by=z有解时，当且仅当z是a和b的最大公约数的倍数
 */
public class No365Math {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        } else if (x + y < z) {
            return false;
        } else if (x + y == z) {
            return true;
        } else if (x > 0 && y > 0) {
            return z % gcd(x, y) == 0;
        } else {
            return false;
        }
    }

    int gcd(int m, int n) {
        if (m < n) {// 保证m>n,若m<n,则进行数据交换
            int temp = m;
            m = n;
            n = temp;
        }
        if (m % n == 0) {// 若余数为0,返回最大公约数
            return n;
        } else { // 否则,进行递归,把n赋给m,把余数赋给n
            return gcd(n, m % n);
        }
    }
}
