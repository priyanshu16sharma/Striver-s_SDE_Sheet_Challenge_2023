//problem-link: https://www.codingninjas.com/studio/problems/merge-k-sorted-arrays_8230770?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i=0; i<kArrays.size(); i++){
			for(int j: kArrays.get(i)){
				pq.add(j);
			}
		}

		ArrayList<Integer> ans = new ArrayList<Integer>();

		while(!pq.isEmpty()){
			ans.add(pq.remove());
		}
		return ans;
	}
}
