//problem: https://www.codingninjas.com/codestudio/problems/missing-and-repeating-numbers_8230733?challengeSlug=striver-sde-challenge


import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) { 
        int xr = 0;

        for (int i = 0; i < n; i++) {
            xr = xr ^ arr.get(i);
            xr = xr ^ (i + 1);
        }

        int number = (xr & ~(xr - 1));

        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            if ((arr.get(i) & number) != 0) {
                one = one ^ arr.get(i);
            } else {
                zero = zero ^ arr.get(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            if ((i & number) != 0) {
                one = one ^ i;
            } else {
                zero = zero ^ i;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == zero) cnt++;
        }

        if (cnt == 2) return new int[] {one, zero};
        return new int[] {zero, one};
    
    }
}