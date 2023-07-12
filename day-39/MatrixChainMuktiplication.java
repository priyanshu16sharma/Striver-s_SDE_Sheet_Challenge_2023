//problem-link: https://www.codingninjas.com/studio/problems/matrix-chain-multiplication_8230769?challengeSlug=striver-sde-challenge&leftPanelTab=0

import java.util.* ;
import java.io.*; 

public class Solution {

	static int helperFunction(int arr[], int i, int j, int[][] dp){
    
    
    if(i == j)
        return 0;
        
    if(dp[i][j]!=-1)
        return dp[i][j];
    
    int mini = Integer.MAX_VALUE;
    
    for(int k = i; k<= j-1; k++){
        
    int ans = helperFunction(arr,i,k,dp) + helperFunction(arr, k+1,j,dp) + arr[i-1]*arr[k]*arr[j];
        
    mini = Math.min(mini,ans);
        
    }
    
    return dp[i][j]=mini;
}
	public static int matrixMultiplication(int[] arr , int N) {
		// Write your code here
		int dp[][] = new int[N][N];

		for(int ar[]: dp){
			Arrays.fill(ar, -1);
		}
		return helperFunction(arr, 1, N-1, dp);
	}
}
