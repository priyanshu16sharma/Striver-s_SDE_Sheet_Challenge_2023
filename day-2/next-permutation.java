//problem: https://www.codingninjas.com/codestudio/problems/next-permutation_8230741?challengeSlug=striver-sde-challenge

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
	static void reverse(ArrayList<Integer> permutation, int start, int end){
		int temp;
        while(start<end){
            temp = permutation.get(start);
            permutation.set(start, permutation.get(end));
            permutation.set(end, temp);
            start++; end--;
        }
	}
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
	{
		// Write your code here.
		int i;
		for(i=permutation.size()-2; i>=0; i--){
			if(permutation.get(i)<permutation.get(i+1)) break;
		}

		if(i<0){
			Collections.sort(permutation);
			return permutation;
		}

		for(int j=permutation.size()-1; j>i; j--){
			if(permutation.get(j)>permutation.get(i)){
				int temp = permutation.get(i);
				permutation.set(i, permutation.get(j));
				permutation.set(j, temp);
				break;
			}
		}
		reverse(permutation, i+1, permutation.size()-1);

		return permutation;
	}
}
