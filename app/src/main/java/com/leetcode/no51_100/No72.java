package com.leetcode.no51_100;

public class No72 {
    public int minDistance(String word1, String word2) {
        int l1=word1.length();
        int l2=word2.length();
        if(l1==0){
            return l2;
        }else if(l2==0){
            return l1;
        }
        char[] chars1=word1.toCharArray();
        char[] chars2=word2.toCharArray();
        int[][] solution=new int[l1][l2];
        if(chars1[0]==chars2[0]){
            solution[0][0]=0;
        }else{
            solution[0][0]=1;
        }
        for(int i=1;i<l1;i++){
            if(chars1[i]==chars2[0]&&i<solution[i-1][0]+1){
                solution[i][0]=i;
            }else{
                solution[i][0]=solution[i-1][0]+1;
            }
        }
        for(int i=1;i<l2;i++){
            if(chars2[i]==chars1[0]&&i<solution[0][i-1]+1){
                solution[0][i]=i;
            }else{
                solution[0][i]=solution[0][i-1]+1;
            }
        }
        for(int i=1;i<l1;i++){
            for(int j=1;j<l2;j++){
                int s1,s2,s3,min;
                if(chars1[i]==chars2[j]){
                    s1=solution[i-1][j-1];
                }else{
                    s1=solution[i-1][j-1]+1;
                }
                s2=solution[i][j-1]+1;
                s3=solution[i-1][j]+1;
                min=Math.min(s1,s2);
                if(s3<min){
                    min=s3;
                }
                solution[i][j]=min;
            }
        }
        return solution[l1-1][l2-1];
    }
}
