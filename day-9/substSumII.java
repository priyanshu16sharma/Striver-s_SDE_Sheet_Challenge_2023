//problem-link : https://www.codingninjas.com/codestudio/problems/subsets-ii_8230855?challengeSlug=striver-sde-challenge&leftPanelTab=1


import java.util.* ;
import java.io.*; 
public class Solution {
    public static void subset(int num[], int vis[], ArrayList<ArrayList<Integer>> ans,  ArrayList<Integer> list, int j){
        for(int i=j; i<num.length; i++){
            if(i!=j&&num[i]==num[i-1]) continue;
            if(vis[i]!=1){
                vis[i]=1;
                list.add(num[i]);
                ans.add(new ArrayList<Integer>(list));
                subset(num, vis, ans, list, i+1);

                // ans.add(0,new ArrayList<Integer>(list));
                list.remove(list.size()-1);
                vis[i]=0;
            }
        }
    }
    
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        // Write your code here..
        int vis[] = new int[arr.length];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ans.add(new ArrayList<Integer>());
        
        Arrays.sort(arr);
        subset(arr, vis, ans,list,0,);

        
        return ans;
    }

}