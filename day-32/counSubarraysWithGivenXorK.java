//link: https://www.codingninjas.com/studio/problems/count-subarrays-with-given-xor_8230830?challengeSlug=striver-sde-

import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		// Write your code here.
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		int currXor=0;
		int count=0;

		hm.put(0, new ArrayList<>());
		hm.get(0).add(-1);
		for(int i=0; i<arr.size(); i++){
			currXor = currXor^arr.get(i);

			if(hm.containsKey(currXor^x)) count+=hm.get(currXor^x).size();

			if(hm.containsKey(currXor)){
				hm.get(currXor).add(i);
			}else{
				hm.put(currXor, new ArrayList<>());
				hm.get(currXor).add(i);
			}
		}

		return count;
	}
}