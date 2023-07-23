//Problem-link: https://www.codingninjas.com/studio/problems/word-break_8230808?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.* ;
import java.io.*; 
public class Solution {

    public static int wordBreakHelper(String target, HashSet<String> hs, int i, int dp[]){
        if(i==target.length()) return dp[i]=1;
        if(dp[i]!=-1) return dp[i];
        StringBuilder s  = new StringBuilder("");

        for(int j=i; j<target.length(); j++){
            s.append(target.charAt(j));
            if(hs.contains(s.toString())){
                if(wordBreakHelper(target, hs, j+1,dp)==1) return dp[i]=1;
            }
        }

        return dp[i]=0;
    }
    public static Boolean wordBreak(String[] arr, int n, String target) {
        // Write your code here.
        int dp[] = new int[target.length()+1];
        HashSet<String> hs = new HashSet<String>();

        for(int i=0; i<arr.length; i++){hs.add(arr[i]);}
        Arrays.fill(dp, -1);

        if(wordBreakHelper(target, hs, 0, dp)==1) return true;


        return false;
    }
}