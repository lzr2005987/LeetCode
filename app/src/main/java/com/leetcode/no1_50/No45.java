package com.leetcode.no1_50;

public class No45 {
    public int jump(int[] nums) {
        int maxPosition = 0;
        int step = 0;
        int i = 0;
        while (maxPosition < nums.length - 1) {
            int max = 0;
            if (i + nums[i] >= nums.length - 1) {
                return step + 1;
            }
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (max <= j + nums[j]) {
                    max = nums[j] + j;
                    maxPosition = j;
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
//    public int jump(int[] nums) {
//        if(nums.length==0){
//            return 0;
//        }
//        int[] ans=new int[nums.length];
//        ans[0]=0;
//        int max=nums[0];
//        int i=0;
//        int cur=1;
//        while(i<nums.length-1){
//            int temp=i+1;
//            if(temp>max){
//                return -1;
//            }
//            int tempMax=max;
//            for(int j=temp;j<=tempMax;j++){
//                ans[j]=cur;
//                max=Math.max(max,j+nums[j]);
//                if(j==nums.length-1){
//                    return cur;
//                }
//                i=j;
//            }
//            cur++;
//        }
//        return ans[ans.length-1];
//    }
}
