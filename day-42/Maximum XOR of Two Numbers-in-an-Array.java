//problem-link: https://www.codingninjas.com/studio/problems/maximum-xor-of-two-numbers-in-an-array_8230852?challengeSlug=striver-sde-challenge


import java.util.* ;
import java.io.*; 
public class Solution {

    public static int maximumXor(int[] A) {
        // Write your Code here
        int max=0;
         for(int i=0; i<A.length; i++){
             for(int j=i; j<A.length; j++){
                 int xor=0;
                 xor=A[i]^A[j];
                 max = Math.max(xor, max);
             }
         }

         return max;
    }
}