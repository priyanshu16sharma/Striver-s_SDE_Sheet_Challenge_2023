//Problem-link: https://www.codingninjas.com/studio/problems/ways-to-make-coin-change_8230691?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.*;
public class Solution {

	public static long countWaysHelper(int denominations[], int value, int i, long dp[][]){
		if(value==0) return dp[i][value]=1;
		if(i<0) return 0;
		
		if(dp[i][value]!=-1) return dp[i][value];
		long count = 0;

		if(denominations[i]<=value){
			count+=countWaysHelper(denominations, value-denominations[i], i, dp);
		}

		count+=countWaysHelper(denominations, value, i-1, dp);

		return dp[i][value]=count;
	}

	public static long countWaysToMakeChange(int denominations[], int value){
        //write your code here

		long dp[][] = new long[denominations.length][value+1];		
		for(long a[]: dp){
            Arrays.fill(a,-1);
        }	
		return countWaysHelper(denominations, value, denominations.length-1, dp);

	}
	
}