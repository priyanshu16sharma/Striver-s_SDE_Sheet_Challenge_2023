//problem.link- https://www.codingninjas.com/studio/problems/chess-tournament_8230779?challengeSlug=striver-sde-challenge&leftPanelTab=1
import java.util.* ;
import java.io.*; 
public class Solution {


    public static boolean isPosition(int positions[], int mindif, int c){
        c--;
        int first = positions[0];

        for(int i=1; i<positions.length; i++){
            if(positions[i]-first>=mindif){
                c--;

                if(c==0) return true;

                first = positions[i];
            }
        }

        return false;
    }

    public static int chessTournament(int[] positions, int n,  int c) 
	{
        // Write your code here.   
        Arrays.sort(positions);

        int max=0;

        int maxdiff =  positions[positions.length-1]-positions[0];
        int low = 1; int high=maxdiff;

        while(low<=high){
            int mid = (low+high)/2;
            if(isPosition(positions, mid, c)){
                max = Math.max(max, mid);
                low = mid+1;
            }else{
                high = mid-1;
            }

        }

        return max;
    }

}