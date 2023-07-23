//problem-link: https://www.codingninjas.com/studio/problems/cut-logs_8230782?challengeSlug=striver-sde-challenge&leftPanelTab=1


import java.util.*;
public class Solution {
    public static int helper(int k, int n, int dp[][]){
        if(dp[n][k]!=-1) return dp[n][k];
        if(n<=0 || k<=0) return 0;
        if(n==1) return dp[n][k]=n;

        if(k==1) return dp[n][k]=n;

        int min = Integer.MAX_VALUE;
        int low=1; int high = n;
        while(low<=high){
            int mid = low+(high-low)/2;
            int broken=helper(k-1, mid-1,dp);
            int notBroken = helper(k,n-mid,dp);
            int temp = 1+ Math.max(broken,notBroken);
            min = Math.min(temp, min);
            if (broken<notBroken)
            {   
            low=mid+1;
            }

         else{

           high=mid-1;

         }
        }

        return dp[n][k]=min;
    }
    public static int cutLogs(int k, int n) {
        //Write your code here
        int dp[][] = new int[n+1][k+1];
        for(int i[]: dp){
            Arrays.fill(i,-1);
        }
        return helper(k,n,dp);
    }

}
