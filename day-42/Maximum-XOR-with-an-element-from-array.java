//problem-link: https://www.codingninjas.com/studio/problems/maximum-xor-with-an-element-from-array_8230839?challengeSlug=striver-sde-challenge

import java.util.*;

public class Solution {
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        // Write your code here.
        Collections.sort(arr);
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<queries.size(); i++){
            int xi = queries.get(i).get(0);
            int ai = queries.get(i).get(1);
            int max=-1;
            for(int j=0; j<arr.size(); j++){
                int xor =0;
                if(ai<arr.get(j)) break;
                xor = xi^arr.get(j);
                max = Math.max(xor, max);
            }
            ans.add(max);
        }

        return ans;
    }
}