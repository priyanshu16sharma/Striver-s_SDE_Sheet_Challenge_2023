//Problem-link: https://www.codingninjas.com/studio/problems/longest-common-prefix_8230847?challengeSlug=striver-sde-challenge&leftPanelTab=1


public class Solution {
	public static String longestCommonPrefix(String[] arr, int n) {
		// Write your code here
		int j=0;
		while(j<arr[0].length()){
			
			char ch = arr[0].charAt(j);
			for(int i=1; i<arr.length; i++){
				if(j<arr[i].length()){
					if(arr[i].charAt(j)!=ch) return arr[0].substring(0, j);
				}else return arr[0].substring(0, j);
			}
			j++;
		}

		return arr[0].substring(0, j);
		
	}

}
