//problem: https://www.codingninjas.com/codestudio/problems/rotate-matrix_8230774?challengeSlug=striver-sde-challenge


import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        // Write your code here.
        //int prev = mat.get(0).get(0);
        int stcol = 0;
        int endcol=m-1;
        int strow = 0;
        int endrow =n-1;
        while(stcol<endcol && strow<endrow){
        int prev = mat.get(strow).get(stcol);
        for(int i=1+stcol; i<=endcol; i++){
            int temp = mat.get(strow).get(i);
            mat.get(strow).set(i, prev);
            prev = temp;
        }
        for(int i=1+strow; i<=endrow; i++){
            int temp = mat.get(i).get(endcol);
            mat.get(i).set(endcol, prev);
            prev = temp;
        }

        for(int i=endcol-1; i>=stcol; i--){
            int temp = mat.get(endrow).get(i);
            mat.get(endrow).set(i, prev);
            prev = temp;
        }

        for(int i=endrow-1; i>=strow; i--){
            int temp = mat.get(i).get(stcol);
            mat.get(i).set(stcol, prev);
            prev = temp;
        }
        strow++;
        stcol++;
        endrow--;
        endcol--;
        }
    }
}
