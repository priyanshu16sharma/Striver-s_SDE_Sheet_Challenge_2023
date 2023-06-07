//problem:- https://www.codingninjas.com/codestudio/problems/day-6-majority-element_8230731?challengeSlug=striver-sde-challenge

import java.io.*;
import java.util.* ;
import java.lang.Math;
public class Solution {
	public static int findMajority(int[] arr, int n) {
		// Write your code here.
		HashMap<Integer, Integer> hm = new HashMap<>();
		int res = -1;
		for(int i=0; i<n; i++){
			if(hm.containsKey(arr[i])){
				int num = hm.get(arr[i] );
				hm.put(arr[i], ++num);
				
				if(num > Math.floor(n/2)) {
					res = arr[i];
				}
			}else{
				hm.put(arr[i], 1);
				if(1 > Math.floor(n/2)) {
					res = arr[i];
				}
			}
		}
		

		return res;
	}
}