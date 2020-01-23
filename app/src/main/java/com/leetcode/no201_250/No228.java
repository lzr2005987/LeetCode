package com.leetcode.no201_250;

import java.util.ArrayList;
import java.util.List;

public class No228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<String>();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0] + "");
        List<String> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (sb.length() == 0) {
                sb.append(nums[i] + "");
            }
            if (nums[i] - 1 == nums[i - 1] && !sb.toString().contains("->")) {
                sb.append("->");
            }
            if (nums[i] - 1 > nums[i - 1]) {
                if (sb.toString().contains("->")) {
                    sb.append(nums[i - 1] + "");
                }
                list.add(sb.toString());
                sb = new StringBuilder(nums[i] + "");
            }
        }
        if (sb.toString().contains("->")) {
            sb.append(nums[nums.length - 1] + "");
            list.add(sb.toString());
        } else if (sb.length() > 0) {
            list.add(sb.toString());
        }
        return list;
    }
}
