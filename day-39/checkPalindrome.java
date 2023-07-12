//problem-link: https://www.codingninjas.com/studio/problems/check-permutation_8230834?challengeSlug=striver-sde-challenge&leftPanelTab=2

import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean areAnagram(String str1, String str2){
        // Write your code here.
        if(str1.length()!=str2.length()) return false;
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0; i<str1.length(); i++){
            char ch = str1.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch)+1);
            }else{
                hm.put(ch, 1);
            }
        }

        int cnt=0;


         for(int i=0; i<str2.length(); i++){
            char ch = str2.charAt(i);
            if(hm.containsKey(ch) && hm.get(ch)>0){
                hm.put(ch, hm.get(ch)-1);
                if(hm.get(ch)==0) hm.remove(ch);
            }
            else{
                return false;
            }
        }

        if(hm.size()==0) return true;

        return false;
    }
}