//problem: https://www.codingninjas.com/codestudio/problems/maximum-subarray-sum_8230694?challengeSlug=striver-sde-challenge


import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
		// write your code here
		long maxSum = 0;
		long cs = 0;
		for(int i=0; i<arr.length; i++){
			cs = cs+arr[i];
			if(cs<0){
				cs = 0;
			}
			
			maxSum = Math.max(cs, maxSum);

		}
		//if(maxSum<0) return 0;
		return maxSum;
	}

}
