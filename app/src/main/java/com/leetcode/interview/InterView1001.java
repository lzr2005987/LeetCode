package com.leetcode.interview;

/**
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class InterView1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                A[k] = B[j];
                j--;
            } else if (j < 0) {
                A[k] = A[i];
                i--;
            } else {
                if (B[j] > A[i]) {
                    A[k] = B[j];
                    j--;
                } else {
                    A[k] = A[i];
                    i--;
                }
            }
            k--;
        }
    }
}
