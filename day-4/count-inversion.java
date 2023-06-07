//problem: https://www.codingninjas.com/codestudio/problems/count-inversions_8230680?challengeSlug=striver-sde-challenge

import java.util.* ;
import java.io.*; 
public class Solution {
    static int mergesort(long arr[], long temp[], int left, int mid, int right){
        int i=left;
        int j = mid;
        int k = left;
        int invCount = 0;
        while(i<=mid-1 && j<=right){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
                invCount = invCount+(mid - i) ;
            }
        }
        while(i<=mid-1) temp[k++] = arr[i++];
        while(j<=right) temp[k++] = arr[j++];

        for( i=left; i<=right; i++){
            arr[i] = temp[i];
        }

        return invCount;

    }
    static int merge(long arr[], long temp[], int left, int right){
        int invCount = 0;
        int mid = 0;
        
        if(left<right){
            mid = (left+right)/2;

            invCount += merge(arr, temp, left, mid);
            invCount+= merge(arr,temp, mid+1, right);

            invCount+=mergesort(arr, temp, left, mid+1, right);
        }

        return invCount;
    }
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        long temp[] = new long[arr.length];
        return merge(arr, temp, 0, n-1);

    }
}