//problem-link: https://www.codingninjas.com/studio/problems/maximum-product-subarray_8230828?challengeSlug=striver-sde-challenge

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {
		// Write your code here.
		int prodl = 1;
		int prodr = 1;
		int max = Integer.MIN_VALUE;

		for(int i=0; i<n; i++){
			prodl *= arr.get(i);
			prodr *= arr.get(n-1-i);
			max = Math.max(max, Math.max(prodl, prodr));
			if(prodl == 0) prodl = 1;
			if(prodr == 0) prodr = 1;
		}

		return max;
	}
}