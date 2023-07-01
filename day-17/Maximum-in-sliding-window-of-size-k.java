//problem-link:https://www.codingninjas.com/studio/problems/maximum-in-sliding-windows-of-size-k_8230772?challengeSlug=striver-sde-challenge&leftPanelTab=0


import java.util.* ;
import java.io.*;

public class Solution 
{

	public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k) 
	{
		//	  Write your code here.
		Deque<Integer> dq = new ArrayDeque<>();
		ArrayList<Integer> ans = new ArrayList<>();

		for(int i=0; i<nums.size(); i++){
			while(!dq.isEmpty()&&dq.peek()==i-k){
				dq.pollFirst();
			}

			while(!dq.isEmpty() && nums.get(dq.peekLast())<nums.get(i)){
				dq.pollLast();
			}

			dq.offer(i);
			if(!dq.isEmpty()&&i>=k-1) ans.add(nums.get(dq.peekFirst()));
		}

		return ans;
	}
}