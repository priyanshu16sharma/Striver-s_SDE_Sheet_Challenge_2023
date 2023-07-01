//question-link: https://www.codingninjas.com/codestudio/problems/day-12-longest-palindromic-substring_8230702?challengeSlug=striver-sde-challenge

import java.util.ArrayList;
import java.util.HashMap;

//import com.sun.tools.classfile.StackMapTable_attribute.chop_frame;

public class Solution {	
	public static boolean isPalindrome(int i, int j, String str){
		int st = i;
		int end = j;
		while(st<end){
			if(str.charAt(st)!=str.charAt(end)) return false;
			st++;
			end--;
		}
		return true;
	}
	public static String longestPalinSubstring(String str) {
		// Write your code here.
		StringBuilder ans = new StringBuilder("");
		HashMap<Character,ArrayList<Integer>> hm = new HashMap<>();
		int ind = 0;
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			if(hm.containsKey(ch)){
				ArrayList<Integer> arr = hm.get(ch);
				for(int it: arr){
					if(isPalindrome(it,i, str)){
						String temp = str.substring(it, i+1);
						if(ans.length()<temp.length() || (ans.length()==temp.length()&& it<ind)){
							ans.delete(0, ans.length());
							ans.append(temp);
							ind = it;
							break;
						}
					}
				}
				hm.get(ch).add(i);
			}else{
				hm.put(ch, new ArrayList<Integer>());
				hm.get(ch).add(i);
			}
		}

		if(ans.length()==0){
			ans.append(str.charAt(0));
		}

		return ans.toString();
	}
}
