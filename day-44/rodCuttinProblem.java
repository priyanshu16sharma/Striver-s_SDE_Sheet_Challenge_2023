//problem-link: https://www.codingninjas.com/studio/problems/rod-cutting-problem_8230727?challengeSlug=striver-sde-challenge

import java.util.*;
public class Solution {
	public static int cutRodHelper(int price[], int n, int i, int dp[][]){
		if(i<0) return 0;
		if(n==0) return dp[i][n]=0;

		if(dp[i][n]!=-1) return dp[i][n];
		int maxi = Integer.MIN_VALUE;
		if((i+1)<=n){
			maxi = Math.max(maxi, price[i]+cutRodHelper(price, n-(i+1), i, dp));
		}

		maxi = Math.max(maxi, cutRodHelper(price, n, i-1, dp));

		return dp[i][n]=maxi;
	}
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int dp[][] = new int[n][n+1];

		for(int a[]: dp){
			Arrays.fill(a,-1);
		}

		return cutRodHelper(price, n, price.length-1, dp);
	}
}