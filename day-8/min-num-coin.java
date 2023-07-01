// problem link:   https://www.codingninjas.com/codestudio/problems/find-minimum-number-of-coins_8230766?challengeSlug=striver-sde-challenge

import java.util.* ;
import java.io.*; 
public class Solution
{
public static int findMinimumCoins(int amount)
    {
        // Write your code here.
        int curr[] = {1,2,5,10,20,50,100,500,1000};
        int j=curr.length-1;
        int count =0;
        while(amount>0){
            while(amount>=curr[j]){
                amount-=curr[j];
                count++;
            }
            j--;
        }

        return count;
    }
}
