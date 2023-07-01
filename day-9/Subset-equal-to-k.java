//problem-link: https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_8230844?challengeSlug=striver-sde-challenge

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int subset(int num[], int vis[], int j, int target, int dp[][]){
        if(target==0) return 1;

        if(j==num.length) return 0;

        if( dp[j][target]!=-1&&dp[j][target]==1) return 1;
        else if(dp[j][target]!=-1&&dp[j][target]==0) return 0;
        for(int i=j; i<num.length; i++){
            if(i!=j&&num[i]==num[i-1]) continue;
            if(vis[i]!=1){
                vis[i]=1;
                int ans=0;
                if(num[i]<=target)
                ans = subset(num, vis, i+1, target-num[i], dp);
                
                vis[i]=0;
                if(ans==1) return dp[i][target]=1;
            }
        }
        return 0;
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int vis[] = new int[arr.length];
        int dp[][] = new int[arr.length+1][k+1];
        for(int it[]:dp) Arrays.fill(it,-1);
        //ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        // ArrayList<Integer> list = new ArrayList<Integer>();
        
        Arrays.sort(arr);
        int ans = subset(arr, vis, 0, k, dp);
         if(ans==1) return true;
         return false;
        
    }
}
