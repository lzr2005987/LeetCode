package com.leetcode;

import java.util.ArrayList;

public class No137 {
    public int singleNumber(int[] nums) {
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        for (Integer i : nums) {
            if (!array1.contains(i) && !array2.contains(i)) {
                array1.add(i);
            } else if (array1.contains(i)) {
                array1.remove(i);
                array2.add(i);
            }
        }
        return array1.get(0);
    }
}
