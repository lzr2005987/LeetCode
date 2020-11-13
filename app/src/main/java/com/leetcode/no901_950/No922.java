package com.leetcode.no901_950;

import java.util.ArrayList;
import java.util.List;

public class No922 {
    public int[] sortArrayByParityII(int[] A) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if ((i % 2 == 0) ^ (A[i] % 2 == 0)) {
                if (i % 2 == 0) {
                    odd.add(i);
                } else {
                    even.add(i);
                }
            }
        }
        for (int i = 0; i < even.size(); i++) {
            int t = A[even.get(i)];
            A[even.get(i)] = A[odd.get(i)];
            A[odd.get(i)] = t;
        }
        return A;
    }
}
