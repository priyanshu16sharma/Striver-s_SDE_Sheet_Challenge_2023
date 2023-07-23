//problem-link: https://www.codingninjas.com/studio/problems/the-celebrity-problem_8230781?challengeSlug=striver-sde-challenge


import java.util.* ;
import java.io.*; 
/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
public class Solution {
	public static int findCelebrity(int n) {
        // Write your code here.
		int celeb = -1;
		boolean celebEx = false;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(Runner.knows(i, j) && j!=i){
					break;
				}

				if(j==n-1){ 
					if(celeb==-1)
					{celeb=i; celebEx=true;}
					else return -1;
				}
			}
		}

		

		return celeb;
    }
}