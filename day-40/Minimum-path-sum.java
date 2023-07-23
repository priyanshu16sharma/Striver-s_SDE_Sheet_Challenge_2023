//problem-link: https://www.codingninjas.com/studio/problems/minimum-path-sum_8230791?challengeSlug=striver-sde-challenge&leftPanelTab=2

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minPathHelper(int grid[][], int i, int j, int dp[][]){
        if(i==0 && j==0){
            return dp[i][j]=grid[i][j];
        }

        if(dp[i][j]!=-1) return dp[i][j];

        int min=Integer.MAX_VALUE;

        if(i>0){
            min = Math.min(min, grid[i][j]+minPathHelper(grid, i-1, j,dp));
        }
        if(j>0){
            min = Math.min(min, grid[i][j]+minPathHelper(grid, i, j-1,dp));
        }

        return dp[i][j]=min;
    }
    public static int minSumPath(int[][] grid) {
    	// Write your code here.
        int dp[][] = new int[grid.length][grid[0].length];

        for(int a[]: dp){
            Arrays.fill(a,-1);
        }
        return minPathHelper(grid, grid.length-1, grid[0].length-1, dp);
    }
}