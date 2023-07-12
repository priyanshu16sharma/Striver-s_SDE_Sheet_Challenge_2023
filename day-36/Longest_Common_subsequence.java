//problem-link: https://www.codingninjas.com/studio/problems/longest-common-subsequence_8230681?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.*;
public class Solution {
static int lcsHelper(String s1, String s2, int i1, int i2, int[][] dp){

    if(i1<0 || i2<0){
        return 0;
	}
    if(dp[i1][i2]!=-1){
        return dp[i1][i2];
	}
    if(s1.charAt(i1) == s2.charAt(i2)){
        return dp[i1][i2] = 1 + lcsHelper(s1,s2,i1-1,i2-1,dp);
	}
    else {
        return dp[i1][i2] = 0 + Math.max(lcsHelper(s1,s2,i1,i2-1,dp),
        lcsHelper(s1,s2,i1-1,i2,dp));
	}
}


public static int lcs(String s1, String s2) {
    
    int n=s1.length();
    int m=s2.length();

    int dp[][]=new int[n][m];

    for(int arr[]: dp)
    Arrays.fill(arr,-1);

    return lcsHelper(s1,s2,n-1,m-1,dp);
}


}