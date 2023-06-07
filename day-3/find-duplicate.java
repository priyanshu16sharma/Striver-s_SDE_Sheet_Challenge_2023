//problem: https://www.codingninjas.com/codestudio/problems/find-duplicate-in-array_8230816?challengeSlug=striver-sde-challenge

import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        // Write your code here.
        int countElem[] = new int[n];
        int ans=0;
        for(int i=0; i<arr.size(); i++){
            countElem[arr.get(i)]++;
            if(countElem[arr.get(i)]>1){
             ans= arr.get(i);
             break;
            }
        }

        return ans;
    }
}
