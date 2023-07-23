//problem-linK: https://www.codingninjas.com/studio/problems/running-median_8230682?challengeSlug=striver-sde-challenge


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	public static void findMedian(int arr[])  {
        
        
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
		PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> b - a);
		PriorityQueue<Integer> minheap = new PriorityQueue<>();



		for(int i=0; i<arr.length; i++){
			if(maxheap.isEmpty() || maxheap.peek()>=arr[i]){
				maxheap.add(arr[i]);
			}else{
				minheap.add(arr[i]);
			}

			if(maxheap.size()>minheap.size()+1){
				minheap.add(maxheap.poll());
			}else if(maxheap.size()<minheap.size()){
				maxheap.add(minheap.poll());
			}

			if(maxheap.size()==minheap.size()){
				System.out.print((maxheap.peek()+minheap.peek())/2+" ");
			}else{
				System.out.print(maxheap.peek()+" ");
			}
		}
    
    }


}