//problem:link https://www.codingninjas.com/codestudio/problems/minimum-number-of-platforms_8230720?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.*;
public class Solution {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        // Write your code here.
        Arrays.sort(at);
        Arrays.sort(dt);

        int i=1;
        int j=0;
        int platformCount = 1;
        int maxCount = 1;
    
        while(i<at.length && j<at.length){
            
            if(at[i]<=dt[j]){
                i++;
                platformCount++;
            }
            else if(at[i]>dt[j]){
                j++;
                platformCount--;
            }

            maxCount = Math.max(platformCount, maxCount);
        }

        return maxCount;

    }
}