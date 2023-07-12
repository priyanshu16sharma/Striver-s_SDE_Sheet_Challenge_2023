//problem-link: https://www.codingninjas.com/studio/problems/630459?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

import java.util.*;
public class Solution {

	private static int binarySearch(ArrayList<Integer> temp, int target) {
        int left = 0;
        int right = temp.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (temp.get(mid) == target) {
                return mid;
            } else if (temp.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
	
		public static int longestIncreasingSubsequence(int[] arr) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        int len = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > temp.get(temp.size() - 1)) {
                temp.add(arr[i]);
                len++;
            } else {
                int idx = binarySearch(temp, arr[i]);
                temp.set(idx, arr[i]);
            }
        }
        return len;
    }
	

}