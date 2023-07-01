//problem-link: https://www.codingninjas.com/codestudio/problems/fractional-knapsack_8230767?challengeSlug=striver-sde-challenge


import java.util.* ;

//import sun.awt.www.content.audio.wav;

import java.io.*; 
/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/


public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
            // Write your code here.
    	    // ITEMS contains {weight, value} pairs.
			Arrays.sort(items, new Comparator<Pair>() {
				public int compare(Pair obj1, Pair obj2){
					double ratio1 = (double)obj1.value/obj1.weight;
					double ratio2 = (double)obj2.value/obj2.weight;

					return Double.compare(ratio2, ratio1);
				}
			});
			double ans=0;

			for(int i=0; i<items.length; i++){
				if(w>=items[i].weight){
					ans+=items[i].value;
					w-=items[i].weight;
				}
				else{
		            ans+= (double) ((double)items[i].value/(double)items[i].weight)*w;
				 	w-=w;
				 }

				if(w==0) break;
			}

			return ans;

    }
}
