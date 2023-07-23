//problem-link: https://www.codingninjas.com/studio/problems/allocate-books_8230810?challengeSlug=striver-sde-challenge

import java.util.* ;
import java.io.*; 
public class Solution {

    public static boolean isPossible(int arr[], long mid, long n){
        long day = 1;
        long sum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>mid) return false;
            if(sum + arr[i]>mid) {
                day+=1;
                if(arr[i]<=mid)
                sum=arr[i];
                else
                return false;
            }else sum+=arr[i];
        }

        if(day>n) return false;

        return true;
    }
    public static long ayushGivesNinjatest(int n, int m,  int[] time) {
        // Write your code here.
        long low=0;long end = 0;long mid=0; long min=0;
        for(int i=0; i<time.length; i++){
            end+= time[i];
            //low = Math.max(low, time[i]);
        }

        while(low<=end){
            mid = (low+end)/2;
            if(isPossible(time, mid, n)){
                min =mid;
                end = mid-1;
            }else{
                low=mid+1;

            }
        }

        return min;

    }
} 