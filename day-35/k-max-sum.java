//problem-link:  https://www.codingninjas.com/studio/problems/day-29-k-max-sum-combinations_8230768?challengeSlug=striver-sde-challenge&leftPanelTab=1


import java.util.* ;
import java.io.*; 
public class Solution{
	public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k){
		// Write your code here.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i: a){
			for(int j: b){
				if(pq.size()<k)
				pq.add(i+j);
				else{
					if(i+j>pq.peek()){
						pq.remove();
						pq.add(i+j);
					}
				}
			}
		}

		while(!pq.isEmpty()){
			arr.add(pq.remove());
			k--;
		}
		Collections.sort(arr, Collections.reverseOrder());

		return arr;
	}
}