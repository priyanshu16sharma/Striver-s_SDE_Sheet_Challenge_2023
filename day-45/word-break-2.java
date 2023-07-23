//problem-link:  https://www.codingninjas.com/studio/problems/word-break-ii_8230786?challengeSlug=striver-sde-challenge


import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static ArrayList<String> helper(String s, HashSet<String> hs, int i, StringBuilder str, ArrayList<String> ans){
       
		if(i==s.length()) ans.add(new String (str.toString()));
        StringBuilder temp = new StringBuilder("");
        int ct = str.length()-1;
		for(int j=i; j<s.length(); j++){
			temp.append(s.charAt(j));
            
			if(hs.contains(temp.toString())){
                str.append(temp);
				if(j!=s.length()-1){ str.append(" "); i++;}
                
				helper(s, hs, j+1, new StringBuilder(str), ans);
                if(str.length()-temp.length()-1>=0)str.delete(str.length()-temp.length()-1, str.length());
			}
		}

		return ans;
	}

	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		// Write your code here.
		HashSet<String> hs = new HashSet<>();
		
		for(int i=0; i<dictionary.size(); i++){
			hs.add(dictionary.get(i));
		}

        //for(String str: hs) System.out.println(str);

		return helper(s, hs, 0, new StringBuilder(""), new ArrayList<>());
	}

}