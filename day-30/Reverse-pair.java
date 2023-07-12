//problem.link: https://www.codingninjas.com/studio/problems/reverse-pairs_8230825?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    static void merge(ArrayList<Integer> arr, int start, int mid, int end){
        int left = start;
        int right = mid+1;
        ArrayList<Integer> temp = new ArrayList<Integer>();

        while(left<=mid && right<=end){
            if(arr.get(left)<arr.get(right)){
                temp.add(arr.get(left));
                left++;
            }else{
                temp.add(arr.get(right));
                right++;
            }

        }

        while(left<=mid ){
                temp.add(arr.get(left));
                left++;
        }

        while(right<=end){
                temp.add(arr.get(right));
                right++;
        }

        for (int i = start; i <= end; i++) {
            arr.set(i,temp.get(i - start));
        }
    }
    static int calculate(ArrayList<Integer> arr, int start, int mid, int end){
        int left = start;
        int right = mid+1;
        int cnt = 0;
        for(int i = left; i<=mid; i++){
            while(right<=end && arr.get(i)>2*arr.get(right)){
                right++;
            }

            cnt+=(right-(mid+1));
        }

        return cnt;
    }
    static int mergesort(ArrayList<Integer> arr, int start, int end){
        int cnt = 0;
        if(start>=end) return cnt;
        int mid = (start+end)/2;
        
       cnt+= mergesort(arr, start, mid);
        cnt+=mergesort(arr, mid+1, end);
        cnt+=calculate(arr, start, mid, end);
        merge(arr, start, mid, end);

        return cnt;

    }
    public static int reversePairs(ArrayList<Integer> arr) 
    {
        // Write your code here.
        return mergesort(arr, 0, arr.size()-1);
    }
}