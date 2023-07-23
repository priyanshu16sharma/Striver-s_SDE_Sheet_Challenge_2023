//problem-link: https://www.codingninjas.com/studio/problems/palindrome-partitioning-ll_8230732?challengeSlug=striver-sde-challenge&leftPanelTab=1


import java.util.* ;
import java.io.*; 
public class Solution {

	public static boolean palindrome(String str, int st, int end){
		while(st<end){
			if(str.charAt(st)!=str.charAt(end))return false;
			st++; end--;
		}

		return true;
	}
	public static int partitionHelper(String str, int st, int dp[]){
		if(st==str.length()) return 0;
		if(dp[st]!=-1) return dp[st];
		int min = Integer.MAX_VALUE;
		for(int i=st; i<str.length(); i++){
			if(palindrome(str, st,i)){
				min = Math.min(1+partitionHelper(str, i+1,dp), min);
			}
		}

		return dp[st]=min;
	}

	public static int palindromePartitioning(String str) {
	    // Write your code here
		int dp[] = new int[str.length()+1];
		Arrays.fill(dp,-1);
		return partitionHelper(str, 0, dp)-1;

	}
}
