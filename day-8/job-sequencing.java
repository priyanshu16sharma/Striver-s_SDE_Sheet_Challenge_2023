//problem-link: https://www.codingninjas.com/codestudio/problems/job-sequencing-problem_8230832?challengeSlug=striver-sde-challenge

import java.util.* ;
import java.io.*; 
public class Solution
{
    public static int jobScheduling(int[][] jobs)
    {
        // Write your code here
        Arrays.sort(jobs, new Comparator<int[]>() {
            public int compare(int[] row1, int[] row2) {
                return Integer.compare(row1[1], row2[1]); 
            }
        });
        int maxtime=0;
        for(int i=0; i<jobs.length; i++){
            maxtime = Math.max(maxtime, jobs[i][0]);
        }
        int profit[]=new int[maxtime+1];
        int ans=0;
        Arrays.fill(profit,-1);
        for(int i=jobs.length-1; i>=0; i--){
            for(int j=jobs[i][0]; j>0; j--){
                if(profit[j]==-1){
                    profit[j]=i;
                     ans+= jobs[i][1];
                    break;
                }
            }
        }

        return ans;
    }
}
