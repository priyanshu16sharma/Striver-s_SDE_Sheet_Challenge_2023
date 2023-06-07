//problem link:- https://www.codingninjas.com/codestudio/problems/search-in-a-2d-matrix_8230773?challengeSlug=striver-sde-challenge

import java.util.ArrayList;
public class Solution {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        // Write your code here.
        boolean res = false;
        for(ArrayList<Integer> a: mat){
            if(a.get(a.size()-1)<target){
                continue;
            }else{
                int start=0; int end=a.size()-1;
                while(start<=end){
                    int mid = (start+end)/2;
                    if(a.get(mid)==target){
                        res= true;
                        break;
                    } 
                    else if(a.get(mid)>target) {
                        end=mid-1;
                    }else{
                        start=mid+1;
                    }
                }

                break;
            }

        }

        return res;
    }
}
