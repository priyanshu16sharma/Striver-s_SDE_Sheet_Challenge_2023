//problem-link: https://www.codingninjas.com/studio/problems/k-th-permutation-sequence_8230822?challengeSlug=striver-sde-challenge

import java.util.*;

public class Solution {

    
    public static String kthPermutation(int n, int k) {
        // Write your code here.
        int fact = 1;
        ArrayList < Integer > numbers = new ArrayList < > ();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        k = k - 1;
        while (true) {
            ans = ans + "" + numbers.get(k / fact);
            numbers.remove(k / fact);
            if (numbers.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }
}