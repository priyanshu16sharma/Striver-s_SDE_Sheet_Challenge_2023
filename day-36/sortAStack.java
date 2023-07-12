// problem-link:  https://www.codingninjas.com/studio/problems/sort-a-stack_8230787?challengeSlug=striver-sde-challenge&leftPanelTab=0

import java.util.* ;
import java.io.*; 
public class Solution {
	public static void sorthelper(Stack<Integer> stack, PriorityQueue<Integer> pq){
		if(stack.isEmpty()) return;

		pq.add(stack.pop());
		sorthelper(stack, pq);
		stack.push(pq.remove());

	}

	// public static void addStack(Stack<Integer> stack, PriorityQueue<Integer> pq){
	// 	if(pq.isEmpty()) return;

	// 	stack.push(pq.remove());
	// 	addStack(stack, pq);
	// }
	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		sorthelper(stack, pq);
		// addStack(stack, pq);

	}

}