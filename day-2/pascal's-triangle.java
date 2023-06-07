/// https://www.codingninjas.com/codestudio/problems/pascal-s-triangle_8230805?challengeSlug=striver-sde-challenge

import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
                 // Write your code here.
		ArrayList<ArrayList<Long>> pastriangle = new ArrayList<ArrayList<Long>>();
		
		ArrayList<Long> ar = new ArrayList<Long>();
		ar.add((long)1);
		pastriangle.add(ar);
		if(n>1){
		ArrayList<Long> ar1 = new ArrayList<Long>();
		ar1.add((long)1); ar1.add((long)1);
	    pastriangle.add(ar1); 
		}
		
		for(int i=0; i<n-2; i++){
			pastriangle.add(new ArrayList<Long>());
		}

		for(int i=2; i<n; i++){
			ArrayList<Long> targarr = pastriangle.get(i);
			ArrayList<Long> prevarr = pastriangle.get(i-1);
			targarr.add((long)1);
			for(int j=0; j<prevarr.size()-1; j++){
				long num1 = prevarr.get(j)+prevarr.get(j+1);
				targarr.add(num1);
			}
			targarr.add((long)1);
		}

		return pastriangle;
	}
}
