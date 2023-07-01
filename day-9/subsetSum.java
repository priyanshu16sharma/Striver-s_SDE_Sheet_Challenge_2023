//problem-link:https://www.codingninjas.com/codestudio/problems/subset-sum_8230859?challengeSlug=striver-sde-challenge&leftPanelTab=0



import java.util.* ;
import java.io.*; 
public class Solution {

    public static void subset(int num[], int vis[], ArrayList<Integer> arr, int sum, int j){
        for(int i=j; i<num.length; i++){
            if(vis[i]!=1){
            vis[i]=1;
            sum+=num[i];
            arr.add(sum);
            subset(num, vis, arr, sum, i);
            vis[i]=0;
            sum-=num[i];
            }
        }
    }
    public static ArrayList<Integer> subsetSum(int num[]) {
        // Write your code here..
        int vis[] = new int[num.length];
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        subset(num, vis, arr,0, 0);
        Collections.sort(arr);
        return arr;
    }

}