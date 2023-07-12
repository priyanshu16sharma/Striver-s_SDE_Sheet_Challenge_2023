//Problem-link: https://www.codingninjas.com/studio/problems/power-set_8230797?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.* ;
import java.io.*; 
public class Solution {

	static void helper(ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> temp, ArrayList<Integer> arr, int ind){
        if(ind==arr.size()) return;
		

		for(int i=ind; i<arr.size(); i++){
		
				temp.add(arr.get(i));
				ans.add(new ArrayList<Integer>(temp));
				helper(ans, temp, arr, i+1);
				
				temp.remove(temp.size()-1);
			
		}
	}
	public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
		// WRITE YOUR CODE HERE
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		//ans.add(new ArrayList<Integer>(temp));
		helper(ans, temp, arr, 0);
		 
		return ans;
	}
}

