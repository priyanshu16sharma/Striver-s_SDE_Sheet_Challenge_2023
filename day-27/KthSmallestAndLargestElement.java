// Problem-link:  https://www.codingninjas.com/studio/problems/kth-smallest-and-largest-element-of-array_8230829?challengeSlug=striver-sde-challenge


import java.util.*;


public class Solution {
	public static int quickSelect(ArrayList<Integer> arr, int st, int end, int k){
		
		int pivot = arr.get(end);
		int pi = partition(arr, pivot, st, end);

		if(pi==k){
			return arr.get(k);
		}else if(pi<k){
			return quickSelect(arr, pi+1, end, k);
		}else{
			return quickSelect(arr, st, pi-1, k);
		}
	}

	public static int partition(ArrayList<Integer> arr, int pivot, int st, int end){
		int i= st;
		int j = st;
		while(i<=end){
			if(arr.get(i)<=pivot){
				int temp = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, temp);
				i++;
				j++;
			}else{
				i++;
			}
		}

		return j-1;
	}
	public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
		//Write your code here
		int first = quickSelect(arr, 0, n-1, k-1);
		int second = quickSelect(arr, 0, n-1, n-k);
	    ArrayList<Integer> ans = new ArrayList<>();
		ans.add(first);
		ans.add(second);
		return ans;

	}
}
