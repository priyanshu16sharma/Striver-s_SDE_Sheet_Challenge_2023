//problem link : https://www.codingninjas.com/codestudio/problems/combination-sum-ii_8230820?challengeSlug=striver-sde-challenge&leftPanelTab=1


import java.util.*;

//import com.sun.accessibility.internal.resources.accessibility;

public class Solution 
{
    public static void comb_sum(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list, int j, int target){
        if(target==0) {ans.add(new ArrayList<>(list)); return;}
        for(int i=j; i<arr.size(); i++){
            if(i!=j && arr.get(i)==arr.get(i-1)) continue;
            if(arr.get(i)>target) break;
            list.add(arr.get(i));
            comb_sum(arr,ans, list, i+1, target-arr.get(i));
            list.remove(list.size()-1);
        }
    }
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
    {
        //    Write your code here.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.sort(arr);
         comb_sum(arr,ans, list, 0, target);
         return ans;
    }
}