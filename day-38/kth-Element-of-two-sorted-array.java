//problem-link: https://www.codingninjas.com/studio/problems/kth-element-of-two-sorted-arrays_8230824?challengeSlug=striver-sde-challenge

public class Solution {
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
        // Write your code here.
        int i=0, j=0, pplCount=0;

        while(i<row1.length && j<row2.length){
            pplCount = i+j+1;
            if(row1[i]<row2[j]) {
                if(pplCount==k) return row1[i];
                i++;
            }else{
                if(pplCount==k) return row2[j];
                j++;
            }
        }

        while(i<row1.length){
            pplCount = i+j+1;
                if(pplCount==k) return row1[i];
                i++;
        }

        while(j<row2.length){
            pplCount = i+j+1;
                if(pplCount==k) return row2[j];
                j++;
        }

        return -1;
    }
}