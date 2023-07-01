//Problem-link:  https://www.codingninjas.com/studio/problems/kth-largest-element-in-the-unsorted-array_8230740?challengeSlug=striver-sde-challenge&leftPanelTab=0


import java.util.* ;
import java.io.*; 
public class Solution {
	public static int quickSelect(ArrayList<Integer> arr, int st, int end, int k){
		int pivot = arr.get(end);
		int pi = partition(arr, st, end, pivot);

		if(pi==k) return arr.get(pi);
		else if(pi>k) return quickSelect(arr, st, pi-1, k);
		else return quickSelect(arr, pi+1, end, k);
	}

	public static int partition(ArrayList<Integer> arr, int st, int end, int pivot){
		int i = st; 
		int j = st;
		 
		while(i<=end){
			if(arr.get(i)<=pivot){
				int temp = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j,temp);
				i++; j++;
			}else{
				i++;
			}
		}

		return j-1;
	}

	static int kthLargest(ArrayList<Integer> arr, int size, int K) {
		// Write your code here.
		return quickSelect(arr, 0, size-1, size-K);
	}
}
