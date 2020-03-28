package com.leetcode.standard;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 完全二叉树中；
 * 第i个节点的父节点=(i-1)/2
 * 第i个节点的两个子节点分别是 i*2+1 和 i*2+2
 * <p>
 * 堆排序：
 * 1 从下往上构建大顶堆
 * 2 堆顶元素和末尾元素交换
 * 3 去掉末尾元素后再次建堆
 * <p>
 * java中可以用PriorityQueue来模拟堆，数字进入队列时就已经是有序的堆了
 */
public class HeapSort {
    //这里传进来的len是下标的最大值，总长度-1
    private static void heapify(int[] a, int len, int pos) {
        if (pos >= len) {
            return;
        }
        int c1 = pos * 2 + 1;
        int c2 = pos * 2 + 2;
        int maxPos = pos;
        if (c2 <= len) {
            maxPos = a[c1] >= a[c2] ? c1 : c2;
            maxPos = a[maxPos] >= a[pos] ? maxPos : pos;
        } else if (c1 <= len) {
            maxPos = a[c1] >= a[pos] ? c1 : pos;
        }
        if (maxPos > pos) {
            int temp = a[maxPos];
            a[maxPos] = a[pos];
            a[pos] = temp;
            heapify(a, len, maxPos);
        }
    }

    private static void buildHeap(int[] a, int len) {
        int start = (len - 1) / 2;
        for (int i = start; i >= 0; i--) {
            heapify(a, len, i);
        }
    }

    public static void sort(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            buildHeap(a, i);
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static PriorityQueue<Integer> JavaHeapSort(int[] a) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t1 - t2;
            }
        });
        for (int item : a) {
            heap.offer(item);
        }
        return heap;
    }

    public static void main(String s[]) {
        int[] a = {3, 5, 6, 8, 3, 6, 8, 3, 2, 7, 9, 2, 3};
        sort(a);
        for (int ans : a) {
            System.out.println(ans);
        }
    }
}
