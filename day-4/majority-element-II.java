//problem- https://www.codingninjas.com/codestudio/problems/majority-element-ii_8230738?challengeSlug=striver-sde-challenge

import java.io.*;
import java.util.* ;
import java.lang.Math;
import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        // Write your code here.
        int n = arr.size();
        HashMap<Integer, Integer> hm = new HashMap<>();
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=0; i<arr.size(); i++){
			if(hm.containsKey(arr.get(i))){
				int num = hm.get(arr.get(i) );
				hm.put(arr.get(i), ++num);
			}else{
				hm.put(arr.get(i), 1);
			}
		}

        for(Map.Entry<Integer, Integer> mapel: hm.entrySet()){
            int key = mapel.getKey();
            int value = mapel.getValue();

            if(value>Math.floor(n/3)){
                ans.add(key);
            }

        }
		

		return ans;
    }
}