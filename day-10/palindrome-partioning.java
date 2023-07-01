//problem-link: https://www.codingninjas.com/codestudio/problems/palindrome-partitioning_8230726?challengeSlug=striver-sde-challenge

import java.util.* ;
import java.io.*; 
public class Solution {
    public static void palindromicSubseq(List<List<String>> ans, List<String> list, String s, int index){
        if(s.length()==index){
            ans.add(new ArrayList<String>(list));
            return;
        }
        for(int i=index; i<s.length(); i++){
            if(palindrome(s, index, i)){
                list.add(s.substring(index, i+1));
                palindromicSubseq(ans, list, s, i+1);
                list.remove(list.size()-1);
            }
        }
    }
    public static boolean palindrome(String s, int st, int end){
        while(st<=end){
            if(s.charAt(st)!=s.charAt(end)) return false;
            st++;
            end--;
        }

        return true;
    }
    public static List<List<String>> partition(String s) {
        // Write your code here.
        List<List<String>> ans = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        palindromicSubseq(ans, list, s, 0);
        return ans;

    }
}