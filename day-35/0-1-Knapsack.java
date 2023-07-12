//problem-link: https://www.codingninjas.com/studio/problems/1072980?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website


import java.util.*;

public class Solution {
    
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		// Write your code here.
		int[][] dp = new int[n+1][w+1];
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                int curr_val= values.get(i-1);
                int curr_wt= weights.get(i-1);
                if(curr_wt<=j){
                    int include = curr_val+dp[i-1][j-curr_wt];
                    int exclude = dp[i-1][j];
                    dp[i][j]=Math.max(include,exclude);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][w];

	}
}