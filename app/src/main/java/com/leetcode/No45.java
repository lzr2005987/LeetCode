package com.leetcode;

public class No45 {
    public int jump(int[] nums) {
        int maxPosition = 0;
        int step = 0;
        int i = 0;
        while (maxPosition < nums.length - 1) {
            int max=0;
            if (i + nums[i] >= nums.length - 1) {
                return step + 1;
            }
            for (int j = i+1; j <= i + nums[i]; j++) {
                if(max<=j+nums[j]){
                    max=nums[j]+j;
                    maxPosition=j;
                }
                if (max >= nums.length - 1) {
                    return step + 2;
                }
            }
            i = maxPosition;
            step++;
        }
        return step;
    }
}
