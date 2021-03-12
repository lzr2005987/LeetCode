package com.leetcode.no301_350;

/**
 * 递推
 * 2的n次方-2的n+1次方的结果等于2的n-1次方到2的n次方对应的数+1
 * 例：10000到11111包含了1000到1111的结果
 */
public class No338 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        int c = 0;
        ans[0] = 0;
        int len = (int) Math.pow(2, c);
        for (int i = 1; i <= num; i++) {
            if (i == len) {
                ans[i] = 1;
                c++;
                len = (int) Math.pow(2, c);
            } else {
                ans[i] = 1 + ans[i - len / 2];
            }
        }
        return ans;
    }
}
