package com.leetcode.interview;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class InterView57 {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while(i!=j){
            int sum=nums[i]+nums[j];
            if(sum>target){
                j--;
            }else if(sum<target){
                i++;
            }else{
                return new int[]{nums[i],nums[j]};
            }
        }
        return new int[2];
    }
}
