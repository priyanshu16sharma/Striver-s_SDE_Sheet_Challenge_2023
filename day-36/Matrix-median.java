//problem-link: https://www.codingninjas.com/studio/problems/matrix-median_8230735?challengeSlug=striver-sde-challenge&leftPanelTab=0


import java.util.ArrayList;

public class Solution
{
	public static ArrayList<Integer> sorthelper(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
		ArrayList<Integer> ans = new ArrayList<>();
		int i=0, j=0;

		while(i<arr1.size() && j<arr2.size()){
			if(arr1.get(i)<arr2.get(j)){
				ans.add(arr1.get(i));
				i++;
			}else {
				ans.add(arr2.get(j));
				j++;
			}
		}

		while(i<arr1.size()){
			ans.add(arr1.get(i));
			i++;
		}

		while(j<arr2.size()){
			ans.add(arr2.get(j));
			j++;
		}

		return ans;

	}
	public static ArrayList<Integer> sortArr(ArrayList<ArrayList<Integer>> matrix){
		ArrayList<Integer> arr = matrix.get(0);

		for(int i=1; i<matrix.size(); i++){
			arr = sorthelper(matrix.get(i), arr);
		}

		return arr;
	}
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		// Write your code here.
		ArrayList<Integer> arr = sortArr(matrix);
		int ind = (0+arr.size()-1)/2;

		return arr.get(ind);
	}
}