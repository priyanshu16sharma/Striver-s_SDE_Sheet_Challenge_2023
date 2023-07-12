//problem-link: https://www.codingninjas.com/studio/problems/k-most-frequent-elements_8230853?challengeSlug=striver-sde-challenge&leftPanelTab=0


import java.util.* ;
import java.io.*; 
public class Solution {

	static class pair{
		int elem;
		int ct;
		pair(int elem , int ct){
			this.elem = elem;
			this.ct = ct;
		}
	}

	public static int[] KMostFrequent(int n, int k, int[] arr) {
		// Write your code here.
		HashMap<Integer, Integer> hm = new HashMap<>();
		PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->b.ct-a.ct);
		for(int i=0; i<arr.length; i++){
			if(hm.containsKey(arr[i])){
				hm.put(arr[i], hm.get(arr[i])+1);
			}else{
				hm.put(arr[i], 1);
			}
		}

		for(int i: hm.keySet()){pq.add(new pair(i, hm.get(i)));}

		int ans[] = new int[k];
		for(int i=0; i<k; i++){ans[i]=pq.remove().elem;}
		return ans;
	}

}


