problem link: https://www.codingninjas.com/codestudio/problems/merge-two-sorted-arrays_8230835?challengeSlug=striver-sde-challenge&leftPanelTab=1
import java.io.*;
import java.util.* ;

public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        // Write your code here.
        int i=arr1.length-1;
        int j=arr2.length-1;
        int k = i-j-1;
        //System.out.println(i+" "+j+" "+k);
        while(k>=0 && j>=0){
            if(arr1[k]<arr2[j]) {
                arr1[i]=arr2[j];
                i--;
                j--;
            }else{
                arr1[i]=arr1[k];
                i--;
                k--;
            }
        }

        while(k>=0){
            arr1[i]=arr1[k];
                i--;
                k--;
        }

        while(j>=0){
            arr1[i]=arr2[j];
                i--;
                j--;
        }

        return arr1;
    }
}
