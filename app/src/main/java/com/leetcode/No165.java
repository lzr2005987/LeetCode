package com.leetcode;

public class No165 {
    public int compareVersion(String version1, String version2) {
        String[] num1=version1.split("\\.");
        String[] num2=version2.split("\\.");
        int shortLen=num1.length<num2.length?num1.length:num2.length;
        int longLen=num1.length>num2.length?num1.length:num2.length;
        for(int i=0;i<shortLen;i++){
            int verNum1=Integer.valueOf(num1[i]);
            int verNum2=Integer.valueOf(num2[i]);
            if(verNum1>verNum2){
                return 1;
            }else if(verNum1<verNum2){
                return -1;
            }
        }
        if(longLen==shortLen){
            return 0;
        }else{
            String[] longNum=num1.length>num2.length?num1:num2;
            for(int i=shortLen;i<longLen;i++){
                int value=Integer.valueOf(longNum[i]);
                if(value>0&&num1.length>num2.length){
                    return 1;
                }else if(value>0&&num1.length<num2.length){
                    return -1;
                }
            }
            return 0;
        }
    }
}
